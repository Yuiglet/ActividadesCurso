package com.metaphorce.shopall.data.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class productosDTOTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    //Nombre
    @Test
    public void testValidProductoNombre() {
        productosDTO productosDTO = new productosDTO();
        productosDTO.setNombre("Producto de ejemplo");

        assertEquals("Producto de ejemplo", productosDTO.getNombre());
    }

    @Test
    public void testProductoNombreIsBlank() {
        productosDTO producto = new productosDTO();
        producto.setNombre(""); // Establece el campo en blanco

        assertTrue(validator.validate(producto).size() > 0);
    }

    // Descripcion
    @Test
    public void testValidProductoDescripcion() {
        productosDTO productosDTO = new productosDTO();
        productosDTO.setDescripcion("Desc de ejemplo");

        assertEquals("Desc de ejemplo", productosDTO.getDescripcion());
    }

    @Test
    public void testProductoDescripcionIsBlank() {
        productosDTO producto = new productosDTO();
        producto.setDescripcion(""); // Establece el campo en blanco

        assertTrue(validator.validate(producto).size() > 0);
    }

    //Precio
    @Test
    public void testValidProductoPrecio() {
        productosDTO productosDTO = new productosDTO();
        Double precio = 20.0; // Precio válido

        productosDTO.setPrecio(precio);

        assertEquals(precio, productosDTO.getPrecio());
    }

    @Test
    public void testInvalidPrice() {
        productosDTO productosDTO = new productosDTO();
        productosDTO.setPrecio(-10.0); // Establecer un precio inválido

        assertTrue(validator.validate(productosDTO).size() > 0);
    }

}
