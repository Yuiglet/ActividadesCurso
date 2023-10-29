package com.metaphorce.shopall.data.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class formapagoDTOTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    //Nombre
    @Test
    public void testValidFormaPagoNombre() {
        formapagoDTO formapagoDTO = new formapagoDTO();
        formapagoDTO.setNombre("forma de pago de ejemplo");

        assertEquals("forma de pago de ejemplo", formapagoDTO.getNombre());
    }

    @Test
    public void testFormaPagoNombreIsBlank() {
        formapagoDTO formadepago = new formapagoDTO();
        formadepago.setNombre(""); // Establece el campo en blanco

        assertTrue(validator.validate(formadepago).size() > 0);
    }

    //Descripcion
    @Test
    public void testValidFormaPagoDeescripcion() {
        formapagoDTO formapagoDTO = new formapagoDTO();
        formapagoDTO.setDescripcion("forma de pago de ejemplo");

        assertEquals("forma de pago de ejemplo", formapagoDTO.getDescripcion());
    }

    @Test
    public void testFormaPagoDescripcionIsBlank() {
        formapagoDTO formadepago = new formapagoDTO();
        formadepago.setDescripcion(""); // Establece el campo en blanco

        assertTrue(validator.validate(formadepago).size() > 0);
    }

}
