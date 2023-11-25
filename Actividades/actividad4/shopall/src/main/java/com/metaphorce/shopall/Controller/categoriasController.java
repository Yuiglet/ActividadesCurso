package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.categoriasDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.service.categoriasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<respuestaGenerica> guardarCategoria(@Valid @RequestBody categoriasDTO dto){
        respuestaGenerica respuesta = CategoriasService.guardarCategoria(dto);
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
