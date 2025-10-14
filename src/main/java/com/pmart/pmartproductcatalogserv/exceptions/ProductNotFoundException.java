package com.pmart.pmartproductcatalogserv.exceptions;

// This is taken as Runtime, which is for scenarios where the exception is not expected to be recovered from
// and can be handled globally using exception handlers

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message){
        super(message);
    }
}