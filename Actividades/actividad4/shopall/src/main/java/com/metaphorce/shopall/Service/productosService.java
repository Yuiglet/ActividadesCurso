package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.exceptions.EntityNotFoundException;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.repository.productosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productosService {
    @Autowired
    private productosRepository ProductosRepository;

    @Autowired
    private categoriasRepository CategoriasRepository;


    public productosDTO nuevoProducto(@Valid productosDTO ProductosDTO){

        productos ProductoNuevo = new productos();

        if (ProductosRepository.existsByNombre(ProductosDTO.getNombre()) & ProductosRepository.existsByDescripcion(ProductosDTO.getDescripcion())) {
            throw new EntityDuplicateException("Producto duplicado");
        }else {
            ProductoNuevo.setNombre(ProductosDTO.getNombre());
            ProductoNuevo.setDescripcion(ProductosDTO.getDescripcion());
        }
        ProductoNuevo.setPrecio(ProductosDTO.getPrecio());
        categorias CategoriaProducto =CategoriasRepository.findById(ProductosDTO.getId_categoria())
                .orElseThrow(() -> new EntityNotFoundException("La categoria con id "+ ProductosDTO.getId_categoria() +" No existe."));
        ProductoNuevo.setId_categoria(CategoriaProducto);
        ProductosRepository.save(ProductoNuevo);
        return ProductosDTO;
    }
}
