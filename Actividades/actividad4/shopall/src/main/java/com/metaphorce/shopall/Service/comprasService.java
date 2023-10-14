package com.metaphorce.shopall.service;

import com.metaphorce.shopall.data.compras;
import com.metaphorce.shopall.data.dto.comprasDTO;
import com.metaphorce.shopall.data.dto.productosDTO;
import com.metaphorce.shopall.data.formapago;
import com.metaphorce.shopall.data.productos;
import com.metaphorce.shopall.data.usuarios;
import com.metaphorce.shopall.repository.comprasRepository;
import com.metaphorce.shopall.repository.formapagoRepository;
import com.metaphorce.shopall.repository.productosRepository;
import com.metaphorce.shopall.repository.usuariosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@Service
public class comprasService {
    @Autowired
    private comprasRepository ComprasRepository;

    @Autowired
    private productosRepository ProductosRepository;

    @Autowired
    private usuariosRepository UsuariosRepository;

    @Autowired
    private formapagoRepository FormapagoRepository;

    @Transactional
    public comprasDTO nuevaCompra(@Valid comprasDTO ComprasDto){

        compras Compra = new compras();

        Compra.setCantidad(ComprasDto.getCantidad());

        Compra.setFecha(new Date());

        usuarios usuarioCompra = UsuariosRepository.findById(ComprasDto.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("El usuario con id "+ ComprasDto.getIdUsuario()+" No existe."));
        Compra.setIdUsuario(usuarioCompra);

        formapago Formapago = FormapagoRepository.findById(ComprasDto.getIdPago())
                .orElseThrow(() -> new EntityNotFoundException("La forma de pago con id "+ ComprasDto.getIdPago()+" No existe."));
        Compra.setIdPago(Formapago);

        double totalCompra = 0.0;

        productos productoCom = ProductosRepository.findById(ComprasDto.getIdProducto())
                .orElseThrow(() -> new EntityNotFoundException("El producto con id "+ ComprasDto.getIdProducto()+" No existe."));
        totalCompra += productoCom.getPrecio() * ComprasDto.getCantidad();

        Compra.setTotal(totalCompra);
        Compra.setIdProducto(productoCom);

        ComprasRepository.save(Compra);

        ComprasDto.setIdCompra(Compra.getIdCompra());
        ComprasDto.setTotal(Compra.getTotal());
        ComprasDto.setCantidad(Compra.getCantidad());
        ComprasDto.setFecha(Compra.getFecha());
        return  ComprasDto;
    }

}
