package com.felipe.controllstock.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.felipe.controllstock.entities.Product;
import com.felipe.controllstock.repositories.ProductRepository;
import com.felipe.controllstock.service.exceptions.ResourceNotFoundExceptions;

@SpringBootTest
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void testFindByIdExistingProduct() {
        // Mock do objeto Product
        Product mockProduct = new Product(1L, "Produto Teste", 10.0, 5);
        
        // Configuração do comportamento do repository para retornar o mockProduct quando findById é chamado
        when(repository.findById(1L)).thenReturn(Optional.of(mockProduct));

        // Chama o método findById do service
        Product result = service.findById(1L);

        // Verifica se o resultado é o mesmo que o mockProduct
        assertEquals(mockProduct, result);
    }

    @Test
    void testFindByIdNonExistingProduct() {
        // Configuração do comportamento do repository para retornar Optional.empty() quando findById é chamado
        when(repository.findById(2L)).thenReturn(Optional.empty());

        // Chama o método findById do service, que deve lançar uma exceção ResourceNotFoundExceptions
        assertThrows(ResourceNotFoundExceptions.class, () -> service.findById(2L));
    }
}
