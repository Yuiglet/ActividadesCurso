package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.dto.usuariosDTO;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.repository.usuariosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class usuariosServiceTest {
    @Mock
    private usuariosRepository UsuariosRepository;

    @InjectMocks
    private usuariosService UsuariosService;

    private usuarios Usuarios;
    private usuariosDTO UsuariosDTO;

    @BeforeEach
    void setUp() {

        Usuarios = new usuarios();
        Usuarios.setIdUsuario(1);
        Usuarios.setCorreo("pedro.cas@ejemplo.com");
        Usuarios.setNomUsuario("PedritoCrack");
        Usuarios.setContrasena("password");
        Usuarios.setNombre("Pedro");
        Usuarios.setApellidoPa("Casa");
        Usuarios.setApellidoMa("Llena");
        Usuarios.setDireccion("Ignacio allende #29");

        UsuariosDTO = new usuariosDTO();
        UsuariosDTO.setCorreo("pedro.cas@ejemplo.com");
        UsuariosDTO.setNomUsuario("PedritoCrack");
        UsuariosDTO.setContrasena("password");
        UsuariosDTO.setNombre("Pedro");
        UsuariosDTO.setApellidoPa("Casa");
        UsuariosDTO.setApellidoMa("Llena");
        UsuariosDTO.setDireccion("Ignacio allende #29");
    }

    @Test
    void getUsuariosTest() {

        when(UsuariosRepository.findAll()).thenReturn(Arrays.asList(Usuarios));

        List<usuariosDTO> result = UsuariosService.getUsuarios();

        // Assert the results
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(Usuarios.getNombre(), result.get(0).getNombre());

        // Verify the interaction with the mock
        verify(UsuariosRepository).findAll();
    }

}
