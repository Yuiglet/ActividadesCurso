package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.formapagoDTO;
import com.metaphorce.shopall.data.formapago;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.repository.formapagoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class formapagoService {
    @Autowired
    private formapagoRepository FormapagoRepository;

    public List<formapagoDTO> getFormapago(){
        List<formapagoDTO> listaFormapago = new ArrayList<>();

        for(formapago forpa: FormapagoRepository.findAll()){

            formapagoDTO formapagoDto = new formapagoDTO();

            formapagoDto.setIdPago(forpa.getIdPago());
            formapagoDto.setNombre(forpa.getNombre());
            formapagoDto.setDescripcion(forpa.getDescripcion());

            listaFormapago.add(formapagoDto);
        }
        return listaFormapago;
    }

    public formapagoDTO guardarFormapago(@Valid formapagoDTO dto){

        formapago Formapago = new formapago();

        if (FormapagoRepository.existsByNombre(dto.getNombre())) {
            throw new EntityDuplicateException("Forma de pago existente");
        }else {
            Formapago.setNombre(dto.getNombre());
        }
        Formapago.setDescripcion(dto.getDescripcion());
        Formapago = FormapagoRepository.save(Formapago);
        dto.setIdPago(Formapago.getIdPago());
        return dto;
    }


}
