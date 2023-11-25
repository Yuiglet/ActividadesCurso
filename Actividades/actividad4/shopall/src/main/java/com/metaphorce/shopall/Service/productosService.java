package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.exceptions.EntityDuplicateException;
import com.metaphorce.shopall.exceptions.EntityNotFoundException;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.repository.productosRepository;
import com.metaphorce.shopall.utils.constantes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productosService {
    @Autowired
    private productosRepository ProductosRepository;

    @Autowired
    private categoriasRepository CategoriasRepository;


    public respuestaGenerica nuevoProducto(productosDTO ProductosDTO){
        respuestaGenerica respuesta = new respuestaGenerica();
        productos productoNuevo = new productos();
        productoNuevo.setDescripcion(ProductosDTO.getDescripcion());
        productoNuevo.setNombre(ProductosDTO.getNombre());
        productoNuevo.setPrecio(ProductosDTO.getPrecio());

        categorias categoria = buscarCategoriaPorId(ProductosDTO.getId_categoria());
        productoNuevo.setId_categoria(categoria);
        ProductosRepository.save(productoNuevo);
        ProductosDTO.setIdProducto(productoNuevo.getIdProducto());
        respuesta.setExito(true);
        respuesta.getDatos().add(ProductosDTO);
        respuesta.setMensaje(constantes.MENSAJE_REGISTRO_PRODUCTO+ProductosDTO.getIdProducto());
        return respuesta;
    }
    private categorias buscarCategoriaPorId(int idCategoria) {
        categorias cat = CategoriasRepository.getReferenceById(idCategoria);
        return cat;
    }
}
