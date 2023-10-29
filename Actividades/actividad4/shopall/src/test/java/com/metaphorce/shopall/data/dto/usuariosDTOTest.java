package com.metaphorce.shopall.data.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class usuariosDTOTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    //Nombre de Usuario
    @Test
    public void testValidNomUsuario() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setNomUsuario("UsuarioValido");

        assertEquals("UsuarioValido", usuariosDTO.getNomUsuario());
    }

    @Test
    public void testInvalidNomUsuario() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setNomUsuario(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Correo
    @Test
    public void testValidCorreo() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setCorreo("usuario@ejemplo.com");

        assertEquals("usuario@ejemplo.com", usuariosDTO.getCorreo());
    }

    @Test
    public void testInvalidCorreo() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setCorreo(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Contraseña
    @Test
    public void testValidContrasena() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setContrasena("claveSegura123");

        assertEquals("claveSegura123", usuariosDTO.getContrasena());
    }

    @Test
    public void testInvalidContrasena() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setContrasena(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Nombre
    @Test
    public void testValidNombre() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setNombre("NombreValido");

        assertEquals("NombreValido", usuariosDTO.getNombre());
    }

    @Test
    public void testInvalidNombre() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setNombre(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Apellido paterno
    @Test
    public void testValidApellidoPa() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setApellidoPa("ApellidoValido");

        assertEquals("ApellidoValido", usuariosDTO.getApellidoPa());
    }

    @Test
    public void testInvalidApellidoPa() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setApellidoPa(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Apellido materno
    @Test
    public void testValidApellidoMa() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setApellidoMa("ApellidoValido");

        assertEquals("ApellidoValido", usuariosDTO.getApellidoMa());
    }

    @Test
    public void testInvalidApellidoMa() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setApellidoMa(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Direccion
    @Test
    public void testValidDireccion() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setDireccion("DireccionValida");

        assertEquals("DireccionValida", usuariosDTO.getDireccion());
    }

    @Test
    public void testInvalidDireccion() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        usuariosDTO.setDireccion(""); // Campo en blanco

        assertTrue(validator.validate(usuariosDTO).size() > 0);
    }

    //Constructor
    @Test
    public void testUsuarioDTOConstructor() {
        usuariosDTO usuariosDTO = new usuariosDTO();
        assertNotNull(usuariosDTO);
    }
}
