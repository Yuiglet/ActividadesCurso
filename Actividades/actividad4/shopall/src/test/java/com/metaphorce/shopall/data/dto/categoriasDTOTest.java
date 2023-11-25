package com.metaphorce.shopall.data.dto;

import com.metaphorce.shopall.data.categorias;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class categoriasDTOTest {
    @Test
    public void testValidNombre() {
        categorias categoria = new categorias();
        categoria.setNombre("Categoría de ejemplo");

        assertEquals("Categoría de ejemplo", categoria.getNombre());
    }

    @Test
    public void testValidDescripcion() {
        categorias categoria = new categorias();
        categoria.setDescripcion("Descripción de la categoría");

        assertEquals("Descripción de la categoría", categoria.getDescripcion());
    }

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    public void testCategoriaNombreIsNull() {
        categoriasDTO categoria = new categoriasDTO();
        categoria.setDescripcion("Una descripción");

        assertTrue(validator.validate(categoria).size() > 0);
    }

    @Test
    public void testCategoriaDescripcionIsNull() {
        categoriasDTO categoria = new categoriasDTO();
        categoria.setNombre("Nombre de la categoría");

        assertTrue(validator.validate(categoria).size() > 0);
    }
}
