package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.data.productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productosRepository extends JpaRepository<productos,Integer> {

}
