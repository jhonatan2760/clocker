package com.jhonatansouza.clocker.clocker.controller;

import com.jhonatansouza.clocker.clocker.dto.request.GasRequest;
import com.jhonatansouza.clocker.clocker.dto.response.GasResponse;
import com.jhonatansouza.clocker.clocker.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gas")
public class GasController {

    private GasService gasService;

    @Autowired
    public GasController(GasService gasService) {
        this.gasService = gasService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GasResponse> pulseGas(@RequestBody GasRequest gasRequest){
        this.gasService.insert(gasRequest.toEntity());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<GasResponse>> getLastPulses(@PageableDefault (value = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(this.gasService
                    .findAll(pageable)
                    .stream()
                    .map(GasResponse::fromEntity)
                    .collect(Collectors.toList())
                );
    }

}
