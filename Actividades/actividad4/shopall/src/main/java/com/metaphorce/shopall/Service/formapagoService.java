package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.formapagoDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.formapago;
import com.metaphorce.shopall.repository.formapagoRepository;
import com.metaphorce.shopall.utils.constantes;
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

    public respuestaGenerica guardarFormapago(@Valid formapagoDTO dto){
        respuestaGenerica respuesta = new respuestaGenerica();
        formapago Formapago = new formapago();
        Formapago.setNombre(dto.getNombre());
        Formapago.setDescripcion(dto.getDescripcion());

        FormapagoRepository.save(Formapago);
        dto.setIdPago(Formapago.getIdPago());
        respuesta.setExito(true);
        respuesta.getDatos().add(dto);
        respuesta.setMensaje(constantes.MENSAJE_REGISTRO_FORMAPAGO+dto.getIdPago());
        return respuesta;
    }


}
