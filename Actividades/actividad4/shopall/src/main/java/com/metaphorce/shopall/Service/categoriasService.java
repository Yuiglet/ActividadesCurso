package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.categoriasDTO;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.repository.categoriasRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoriasService {

    @Autowired
    private categoriasRepository CategoriasRepository;

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

    public categoriasDTO guardarCategoria(@Valid categoriasDTO dto){

        categorias Categorias = new categorias();

        if (CategoriasRepository.existsByNombre(dto.getNombre())) {
            throw new EntityDuplicateException("Forma de pago existente");
        }else {
            Categorias.setNombre(dto.getNombre());
        }
        Categorias.setDescripcion(dto.getDescripcion());
        Categorias = CategoriasRepository.save(Categorias);
        dto.setIdCategoria(Categorias.getIdCategoria());
        return dto;
    }
}
