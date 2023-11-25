package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.data.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios,Integer> {

    boolean existsByCorreo(String correo);

    boolean existsByNomUsuario(String nomUsuario);

    Optional<usuarios> findByNomUsuario(String nomUsuario);
}
