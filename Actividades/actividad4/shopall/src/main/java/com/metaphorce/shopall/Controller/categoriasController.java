package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.categoriasDTO;
import com.metaphorce.shopall.service.categoriasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "shopall")
@RestController
@Validated
public class categoriasController {
    private final categoriasService CategoriasService;
    @Autowired
    public categoriasController (categoriasService CategoriasService){

        this.CategoriasService = CategoriasService;
    }

    @GetMapping("/categorias")
    public List<categoriasDTO> getCategorias(){
        return CategoriasService.getCategorias();
    }

    @PostMapping("/guardaCategoria")
    public categoriasDTO guardarCategoria(@Valid @RequestBody categoriasDTO dto){
        return CategoriasService.guardarCategoria(dto);
    }
}
