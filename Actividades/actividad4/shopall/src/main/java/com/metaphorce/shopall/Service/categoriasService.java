package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.categoriasDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.utils.constantes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoriasService {

    private final categoriasRepository CategoriasRepository;

    @Autowired
    public categoriasService(categoriasRepository CategoriasRepository) {
        this.CategoriasRepository = CategoriasRepository;
    }
    public List<categoriasDTO> getCategorias(){
        List<categoriasDTO> listaCategorias = new ArrayList<>();

        for(categorias cate: CategoriasRepository.findAll()){

            categoriasDTO CategoriasDTO = new categoriasDTO();

            CategoriasDTO.setIdCategoria(cate.getIdCategoria());
            CategoriasDTO.setNombre(cate.getNombre());
            CategoriasDTO.setDescripcion(cate.getDescripcion());

            listaCategorias.add(CategoriasDTO);
        }
        return listaCategorias;
    }

    public respuestaGenerica guardarCategoria(@Valid categoriasDTO dto){
        respuestaGenerica respuesta = new respuestaGenerica();
        categorias Categorias = new categorias();
        Categorias.setNombre(dto.getNombre());
        Categorias.setDescripcion(dto.getDescripcion());

        CategoriasRepository.save(Categorias);
        dto.setIdCategoria(Categorias.getIdCategoria());
        respuesta.setExito(true);
        respuesta.getDatos().add(dto);
        respuesta.setMensaje(constantes.MENSJAE_REGISTRO_CATEGORIA+dto.getIdCategoria());
        return respuesta;
    }
}
