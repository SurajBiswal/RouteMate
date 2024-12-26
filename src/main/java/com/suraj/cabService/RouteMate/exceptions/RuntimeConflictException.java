package com.suraj.cabService.RouteMate.exceptions;

public class RuntimeConflictException extends RuntimeException{
    public RuntimeConflictException(){
    }

    public RuntimeConflictException(String message){
        super(message);
    }
}
