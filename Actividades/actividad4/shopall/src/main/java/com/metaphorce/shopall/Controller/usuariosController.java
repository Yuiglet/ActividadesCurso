package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.service.usuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "shopall")
@RestController
@Validated
public class usuariosController {
    private final usuariosService UsuariosService;
    @Autowired
    public usuariosController (usuariosService UsuariosService){

        this.UsuariosService = UsuariosService;
    }

    @GetMapping("/usuarios")
    public List<usuariosDTO> getTodosUsuarios(){
        return UsuariosService.getUsuarios();
    }

    @PostMapping("/guardarUsuarios")
    public usuariosDTO guardarUsuario(@Valid @RequestBody usuariosDTO dto){
        return UsuariosService.guardarUsuario(dto);
    }
}
