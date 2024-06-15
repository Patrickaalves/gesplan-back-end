package com.patrick.gesplanbakend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    /***
     Exception criada, com o objetivo de caso não encontrar algo buscado no banco de dados
     retornar com uma mensagem customizada
     ***/

    public ResourceNotFoundException(String message){
        super(message);
    }
}
