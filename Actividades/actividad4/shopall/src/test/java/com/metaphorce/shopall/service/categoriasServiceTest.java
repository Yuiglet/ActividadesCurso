package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.categorias;
import com.metaphorce.shopall.data.dto.categoriasDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.repository.categoriasRepository;
import com.metaphorce.shopall.utils.constantes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class categoriasServiceTest {

    @Mock
    private categoriasRepository CategoriasRepository;

    @InjectMocks
    private categoriasService CategoriasService;

    private categoriasDTO CategoriasDTO;
    private categorias Categorias;

    @BeforeEach
    void setUp() {

        CategoriasDTO = new categoriasDTO();
        CategoriasDTO.setNombre("Limpieza");
        CategoriasDTO.setDescripcion("Productos de limpieza para el hogar");

        Categorias = new categorias();
        Categorias.setNombre(CategoriasDTO.getNombre());
        Categorias.setDescripcion(CategoriasDTO.getDescripcion());

    }
    @Test
    void setCategoriaExitosa() {

        when(CategoriasRepository.save(any(categorias.class))).thenAnswer(invocation -> {
            categorias c = invocation.getArgument(0);
            c.setIdCategoria(1);// Simular ID generado
            return c;
        });

        respuestaGenerica respuesta = CategoriasService.guardarCategoria(CategoriasDTO);

        // Verificar los resultados
        assertTrue(respuesta.isExito());
        assertNotNull(respuesta.getDatos());
        assertFalse(respuesta.getDatos().isEmpty());
        assertEquals(constantes.MENSJAE_REGISTRO_CATEGORIA + "1", respuesta.getMensaje());

        // Verificar la interacción con los mocks
        verify(CategoriasRepository).save(any(categorias.class));
    }

}
