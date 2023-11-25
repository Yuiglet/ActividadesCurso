package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.comprasDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.service.comprasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("shopall/compras")
@Validated
public class comprasController {

    @Autowired
    private comprasService ComprasService;



    @PostMapping("/comprar")
    public ResponseEntity<respuestaGenerica> guardarCompra(@Valid @RequestBody comprasDTO ComprasDTO){
        respuestaGenerica respuesta = ComprasService.nuevaCompra(ComprasDTO);
        HttpStatus status = null;
        if(respuesta.isExito()){
            status =  HttpStatus.OK;
            respuesta.setCodigo(status.value());
        }else{
            status = HttpStatus.BAD_REQUEST;
            respuesta.setCodigo(status.value());
        }
        return new ResponseEntity<>(respuesta,status);
    }
}
