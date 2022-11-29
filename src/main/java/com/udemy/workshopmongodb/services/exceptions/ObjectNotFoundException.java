package com.udemy.workshopmongodb.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Object id){
        super("O objeto '"  + id + "' não foi encontrado");
    }

}