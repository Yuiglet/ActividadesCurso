package com.metaphorce.shopall.data.dto;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class comprasDTOTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    //Cantidad
    @Test
    public void testValidComprasCantidad() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setCantidad(5);

        assertEquals(Integer.valueOf(5), comprasDTO.getCantidad());
    }

    @Test
    public void testInvalidComprasCantidad() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setCantidad(-5); // Cantidad no puede ser negativa

        assertTrue(validator.validate(comprasDTO).size() > 0);
    }

    //Fecha
    @Test
    public void testValidDate() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setFecha(new Date());

        assertEquals(new Date(), comprasDTO.getFecha());
    }

    //Total
    @Test
    public void testValidComprasTotal() {
        comprasDTO comprasDTO = new comprasDTO();
        Double total = 30.90;
        comprasDTO.setTotal(total);

        assertEquals(total, comprasDTO.getTotal());
    }

    //IdProducto
    @Test
    public void testValidIdProducto() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdProducto(10); // Un ID de producto válido

        assertEquals(Integer.valueOf(10), comprasDTO.getIdProducto());
    }

    @Test
    public void testInvalidIdProducto() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdProducto(-5); // Un ID de producto no puede ser negativo

        assertTrue(validator.validate(comprasDTO).size() > 0);
    }

    //IdUsuario
    @Test
    public void testValidIdUsuario() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdUsuario(20); // Un ID de usuario válido

        assertEquals(Integer.valueOf(20), comprasDTO.getIdUsuario());
    }

    @Test
    public void testInvalidIdUsuario() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdUsuario(-5); // Un ID de usuario no puede ser negativo

        assertTrue(validator.validate(comprasDTO).size() > 0);
    }

    //IdPago
    @Test
    public void testValidIdPago() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdPago(30); // Un ID de pago válido

        assertEquals(Integer.valueOf(30), comprasDTO.getIdPago());
    }

    @Test
    public void testInvalidIdPago() {
        comprasDTO comprasDTO = new comprasDTO();
        comprasDTO.setIdPago(-5); // Un ID de pago no puede ser negativo

        assertTrue(validator.validate(comprasDTO).size() > 0);
    }
}
