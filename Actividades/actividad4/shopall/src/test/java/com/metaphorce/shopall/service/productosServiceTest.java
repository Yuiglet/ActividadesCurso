package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.repository.productosRepository;
import com.metaphorce.shopall.utils.constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class productosServiceTest {

    @Mock
    private productosRepository ProductosRepository;

    @Mock
    private categoriasRepository CategoriasRepository;

    @InjectMocks
    private productosService ProductosService;

    private productosDTO ProductosDTO;
    private productos Productos;
    private categorias Categorias;

    @BeforeEach
    void setUp() {

        Categorias = new categorias();
        Categorias.setIdCategoria(1);
        Categorias.setNombre("Limpieza");
        Categorias.setDescripcion("Productos de limpieza para el hogar");


        ProductosDTO = new productosDTO();
        ProductosDTO.setNombre("Escoba");
        ProductosDTO.setDescripcion("Escoba economica");
        ProductosDTO.setPrecio(30.00);
        ProductosDTO.setId_categoria(Categorias.getIdCategoria());

        Productos = new productos();
        Productos.setNombre(ProductosDTO.getNombre());
        Productos.setDescripcion(ProductosDTO.getDescripcion());
        Productos.setPrecio(ProductosDTO.getPrecio());
        Productos.setId_categoria(Categorias);
    }
    @Test
    void setProductoExitoso() {

        when(CategoriasRepository.getReferenceById(any(Integer.class))).thenReturn(Categorias);
        when(ProductosRepository.save(any(productos.class))).thenAnswer(invocation -> {
            productos p = invocation.getArgument(0);
            p.setIdProducto(1); // Simular ID generado
            return p;
        });

        respuestaGenerica respuesta = ProductosService.nuevoProducto(ProductosDTO);

        // Verificar los resultados
        assertTrue(respuesta.isExito());
        assertNotNull(respuesta.getDatos());
        assertFalse(respuesta.getDatos().isEmpty());
        assertEquals(constantes.MENSAJE_REGISTRO_PRODUCTO + "1", respuesta.getMensaje());

        // Verificar la interacción con los mocks
        verify(CategoriasRepository).getReferenceById(any(Integer.class));
        verify(ProductosRepository).save(any(productos.class));
    }
}
