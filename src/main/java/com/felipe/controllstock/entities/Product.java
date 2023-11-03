package com.felipe.controllstock.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;

    // Construtor padrão
    public Product() {

    }

    // Construtor com argumentos
    public Product(Long id, String nome, Double preco, Integer quantidade) {
        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e Setters para os atributos da classe

    // Método hashCode para gerar um código hash baseado nos atributos da classe
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, quantidade);
    }

    // Método equals para comparar dois objetos da classe Product
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco)
                && Objects.equals(quantidade, other.quantidade);
    }
}
