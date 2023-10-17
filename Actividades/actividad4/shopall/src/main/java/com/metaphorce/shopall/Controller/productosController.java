package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.service.productosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public productosDTO guardarProducto(@Valid @RequestBody  productosDTO productosDTO){
        return ProductosService.nuevoProducto(productosDTO);
    }
}
