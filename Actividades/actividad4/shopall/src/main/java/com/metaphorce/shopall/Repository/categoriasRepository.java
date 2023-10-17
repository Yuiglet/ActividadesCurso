package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.data.categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriasRepository extends JpaRepository<categorias,Integer> {
    boolean existsByNombre(String nombre);
}
