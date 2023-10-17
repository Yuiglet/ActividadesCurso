package com.metaphorce.shopall.data.dto;

import com.metaphorce.shopall.data.compras;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
/**
 * DTO for {@link compras}
 */
@Setter
@Getter
@Validated
public class comprasDTO {

    private int idCompra;

    @NotNull(message = "Debe ingresar una cantidad de producto")
    @Positive(message = "Debe ingresar una cantidad valida")
    private Integer cantidad;

    private Date fecha;

    private Double total;

    @NotNull(message = "Debe ingresar un producto")
    @Positive(message = "Debe ingresar un producto valido")
    private Integer idProducto;

    @NotNull(message = "Debe ingresar un usuario")
    @Positive(message = "Debe ingresar un usuario valido")
    private Integer idUsuario;

    @NotNull(message = "Debe ingresar una forma de pago")
    @Positive(message = "Debe ingresar una forma de pago valida")
    private Integer idPago;


}
