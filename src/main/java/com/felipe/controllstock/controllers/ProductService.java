package com.felipe.controllstock.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipe.controllstock.entities.Product;
import com.felipe.controllstock.repositories.ProductRepository;
import com.felipe.controllstock.service.exceptions.ResourceNotFoundExceptions;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	// Método para obter todos os produtos
	public List<Product> findAll() {
		return repository.findAll();
	}

	// Método para obter um produto por ID
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		// Verifica se o produto foi encontrado, caso contrário, lança uma exceção
		return obj.orElseThrow(() -> new ResourceNotFoundExceptions(id));
	}

	// Método para inserir um novo produto
	public Product insert(Product obj) {
		return repository.save(obj);
	}
	
	// Método para deletar um produto por ID
	public void delete(Long id) {
		// Verifica se o produto com o ID especificado existe antes de tentar deletar
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundExceptions(id);
		}
		repository.deleteById(id);
	}

}
