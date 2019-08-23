package com.jhonatansouza.clocker.clocker.controller;

import com.jhonatansouza.clocker.clocker.dto.request.GasRequest;
import com.jhonatansouza.clocker.clocker.dto.response.GasResponse;
import com.jhonatansouza.clocker.clocker.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<GasResponse>> getLastPulses(){
        return ResponseEntity.ok(this.gasService.findAll().stream().map(GasResponse::fromEntity).collect(Collectors.toList()));
    }

}
