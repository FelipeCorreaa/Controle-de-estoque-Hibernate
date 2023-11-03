package com.felipe.controllstock.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.felipe.controllstock.controllers.ProductService;
import com.felipe.controllstock.entities.Product;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    // Injeção de dependência do ProductService
    @Autowired
    private ProductService service;

    // Endpoint para obter todos os produtos
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Endpoint para obter um produto por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Endpoint para adicionar um novo produto
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    // Endpoint para deletar um produto por ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
