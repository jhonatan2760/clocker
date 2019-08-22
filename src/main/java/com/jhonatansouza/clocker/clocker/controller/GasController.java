package com.jhonatansouza.clocker.clocker.controller;

import com.jhonatansouza.clocker.clocker.dto.request.GasRequest;
import com.jhonatansouza.clocker.clocker.dto.response.GasResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gas")
public class GasController {

    public GasController() {
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GasResponse> pulseGas(@RequestBody GasRequest gasRequest){

        return ResponseEntity.ok().build();
    }

}
