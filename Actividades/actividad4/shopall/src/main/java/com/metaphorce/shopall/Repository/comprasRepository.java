package com.metaphorce.shopall.repository;

import com.metaphorce.shopall.data.compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface comprasRepository extends JpaRepository<compras,Integer> {

}
