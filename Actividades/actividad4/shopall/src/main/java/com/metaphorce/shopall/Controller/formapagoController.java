package com.metaphorce.shopall.controller;

import com.metaphorce.shopall.data.dto.formapagoDTO;
import com.metaphorce.shopall.service.formapagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public formapagoDTO guardarFormapago(@Valid @RequestBody formapagoDTO dto){
        return FormapagoService.guardarFormapago(dto);
    }
}
