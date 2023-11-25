package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.service.usuariosService;
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
    public ResponseEntity<respuestaGenerica> guardarUsuario(@Valid @RequestBody usuariosDTO dto){
        respuestaGenerica respuesta = UsuariosService.guardarUsuario(dto);
        HttpStatus status = null;
        if(respuesta.isExito()){
            status = HttpStatus.OK;
            respuesta.setCodigo(status.value());
        }else{
            status = HttpStatus.BAD_REQUEST;
            respuesta.setCodigo(status.value());
        }
        return new ResponseEntity<>(respuesta,status);
    }
}
