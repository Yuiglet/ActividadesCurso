package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.compras;
import com.metaphorce.shopall.data.dto.comprasDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.formapago;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.exceptions.EntityNotFoundException;
import com.metaphorce.shopall.repository.comprasRepository;
import com.metaphorce.shopall.repository.formapagoRepository;
import com.metaphorce.shopall.repository.productosRepository;
import com.metaphorce.shopall.repository.usuariosRepository;
import com.metaphorce.shopall.utils.constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class comprasServiceTest {
    @Mock
    private comprasRepository ComprasRepository;

    @Mock
    private productosRepository ProductosRepository;

    @Mock
    private usuariosRepository UsuariosRepository;

    @Mock
    private formapagoRepository FormaPagoRepository;


    @InjectMocks
    private comprasService ComprasService;

    private comprasDTO ComprasDTO;
    private compras Compras;
    private usuarios Usuarios;
    private formapago Formapago;
    private productos Productos;

    @BeforeEach
    void setUp() {
        // Crear datos de prueba
        Usuarios = new usuarios();
        Usuarios.setIdUsuario(1);

        Formapago = new formapago();
        Formapago.setIdPago(1);

        Productos = new productos();
        Productos.setIdProducto(1);
        Productos.setPrecio(100.0);


        ComprasDTO = new comprasDTO();
        ComprasDTO.setIdUsuario(Usuarios.getIdUsuario());
        ComprasDTO.setIdPago(Formapago.getIdPago());
        ComprasDTO.setIdProducto(Productos.getIdProducto());
        ComprasDTO.setCantidad(4);

        Compras = new compras();
        Compras.setIdUsuario(Compras.getIdUsuario());
        Compras.setIdPago(Formapago);
        Compras.setIdProducto(Productos);
        Compras.setCantidad(ComprasDTO.getCantidad());
        Compras.setTotal(ComprasDTO.getCantidad() * Productos.getPrecio());

    }
    @Test
    void generarCompraExitosa() {
        when(UsuariosRepository.findById(any(Integer.class))).thenReturn(Optional.of(Usuarios));
        when(FormaPagoRepository.findById(any(Integer.class))).thenReturn(Optional.of(Formapago));
        when(ProductosRepository.findById(any(Integer.class))).thenReturn(Optional.of(Productos));
        when(ComprasRepository.save(any(compras.class))).then(i -> {
            compras compra = i.getArgument(0);

            compra.setIdCompra(1);
            return compra;
        });


        respuestaGenerica respuesta = ComprasService.nuevaCompra(ComprasDTO);

        // Verificaciones y aserciones
        assertTrue(respuesta.isExito());
        assertEquals(constantes.MENSAJE_EXITO_COMPRA, respuesta.getMensaje());
        assertNotNull(ComprasDTO.getIdCompra());
        assertEquals(100.0 * 4, Compras.getTotal());

        // Verificar interacciones con los mocks
        verify(ComprasRepository).save(any(compras.class));
    }

    @Test
    void generarCompraConUsuarioInexistente() {
        // Configurar comportamiento del mock para lanzar la excepción
        when(UsuariosRepository.findById(any(Integer.class))).thenThrow(new EntityNotFoundException(constantes.USUARIO_NO_EXISTENTE));

        // Ejecutar y verificar que se lanza la excepción
        assertThrows(EntityNotFoundException.class, () -> ComprasService.nuevaCompra(ComprasDTO));
    }
}
