package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.comprasDTO;
import com.metaphorce.shopall.service.comprasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("shopall/compras")
@Validated
public class comprasController {

    @Autowired
    private comprasService ComprasService;



    @PostMapping("/comprar")
    public  comprasDTO guardarCompra(@Valid @RequestBody comprasDTO ComprasDTO){
        return ComprasService.nuevaCompra(ComprasDTO);
    }
}
