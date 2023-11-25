package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.formapagoDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.service.formapagoService;
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
public class formapagoController {
    private final formapagoService FormapagoService;
    @Autowired
    public formapagoController (formapagoService FormapagoService){

        this.FormapagoService = FormapagoService;
    }

    @GetMapping("/formapago")
    public List<formapagoDTO> getTodosUsuarios(){
        return FormapagoService.getFormapago();
    }

    @PostMapping("/guardaFormapago")
    public ResponseEntity<respuestaGenerica> guardarFormapago(@Valid @RequestBody formapagoDTO dto){
        respuestaGenerica respuesta = FormapagoService.guardarFormapago(dto);
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
