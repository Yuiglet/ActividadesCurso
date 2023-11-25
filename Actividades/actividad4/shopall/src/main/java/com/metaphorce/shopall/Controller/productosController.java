package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.service.productosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "shopall/productos")
@RestController
@Validated
public class productosController {
    @Autowired
    private productosService ProductosService;


    @PostMapping("/guardar")
    public ResponseEntity<respuestaGenerica> guardarProducto(@RequestBody  productosDTO ProductoDTO){

        respuestaGenerica respuesta = ProductosService.nuevoProducto(ProductoDTO);
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
