package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.formapagoDTO;
import com.metaphorce.shopall.data.dto.respuestaGenerica;
import com.metaphorce.shopall.data.formapago;
import com.metaphorce.shopall.repository.formapagoRepository;
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
public class formapagoServiceTest {
    @Mock
    private formapagoRepository FormapagoRepository;

    @InjectMocks
    private formapagoService FormapagoService;

    private formapagoDTO FormapagoDTO;
    private formapago formapagoN;

    @BeforeEach
    void setUp() {

        FormapagoDTO = new formapagoDTO();
        FormapagoDTO.setNombre("Tarjeta de debito");
        FormapagoDTO.setDescripcion("Cualquier tarjeta de debito");

        formapagoN = new formapago();
        formapagoN.setNombre(FormapagoDTO.getNombre());
        formapagoN.setDescripcion(FormapagoDTO.getDescripcion());

    }
    @Test
    void setFormapagoExitosa() {

        when(FormapagoRepository.save(any(formapago.class))).thenAnswer(invocation -> {
            formapago f = invocation.getArgument(0);
            f.setIdPago(1);// Simular ID generado
            return f;
        });

        respuestaGenerica respuesta = FormapagoService.guardarFormapago(FormapagoDTO);

        // Verificar los resultados
        assertTrue(respuesta.isExito());
        assertNotNull(respuesta.getDatos());
        assertFalse(respuesta.getDatos().isEmpty());
        assertEquals(constantes.MENSAJE_REGISTRO_FORMAPAGO + "1", respuesta.getMensaje());

        // Verificar la interacción con los mocks
        verify(FormapagoRepository).save(any(formapago.class));
    }
}
