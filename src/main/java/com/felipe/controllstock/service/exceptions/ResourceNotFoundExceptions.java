package com.felipe.controllstock.service.exceptions;

// Classe de exceção personalizada para indicar que um recurso não foi encontrado
public class ResourceNotFoundExceptions extends RuntimeException{

    /**
     * Identificador único da versão da classe (serialVersionUID)
     */
    private static final long serialVersionUID = 1L;
    
    // Construtor que aceita um objeto de identificação e gera a mensagem de exceção
    public ResourceNotFoundExceptions(Object id) {
        super("Resource not found. ID: " + id);
    }

}
