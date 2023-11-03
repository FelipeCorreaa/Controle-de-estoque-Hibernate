package com.felipe.controllstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.controllstock.entities.Product;

// Esta interface estende JpaRepository para obter operações de CRUD para a entidade Product
public interface ProductRepository extends JpaRepository<Product, Long> {


}
