package com.pmart.pmartproductcatalogserv.exceptions;

public class OperationException extends RuntimeException{
    public OperationException(String message){
        super(message);
    }
}