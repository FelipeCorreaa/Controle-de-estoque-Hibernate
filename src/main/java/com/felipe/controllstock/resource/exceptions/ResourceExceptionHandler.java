package com.felipe.controllstock.resource.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipe.controllstock.service.exceptions.ResourceNotFoundExceptions;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	// Manipula a exceção ResourceNotFoundExceptions
	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<StandardError> resouceNotfoud(ResourceNotFoundExceptions e, HttpServletRequest request){
		String error="Resource not found";
		HttpStatus status =HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		// Retorna uma resposta com o status de erro e um objeto StandardError
		return ResponseEntity.status(status).body(err);
	}
}
