package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.repository.productosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productosService {
    @Autowired
    private productosRepository ProductosRepository;

    @Autowired
    private categoriasRepository CategoriasRepository;


    public productosDTO nuevoProducto(productosDTO ProductosDTO){
        productos ProductoNuevo = new productos();
        ProductoNuevo.setNombre(ProductosDTO.getNombre());
        ProductoNuevo.setDescripcion(ProductosDTO.getDescripcion());
        ProductoNuevo.setPrecio(ProductosDTO.getPrecio());

        categorias Categorias = buscarCategoriaPorId(ProductosDTO.getId_categoria());
        ProductoNuevo.setId_categoria(Categorias);
        ProductosRepository.save(ProductoNuevo);
        return ProductosDTO;
    }

    private categorias buscarCategoriaPorId(int idCategoria) {
        categorias cat = CategoriasRepository.getReferenceById(idCategoria);
        return cat;
    }
}
