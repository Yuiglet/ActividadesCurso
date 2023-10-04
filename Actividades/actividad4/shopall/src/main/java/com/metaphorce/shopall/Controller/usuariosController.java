package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.service.usuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(path = "shopall")
@RestController
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
    public usuariosDTO guardarUsuario(@RequestBody usuariosDTO dto){
        return UsuariosService.guardarUsuario(dto);
    }
}
