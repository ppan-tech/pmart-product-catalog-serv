package com.pmart.pmartproductcatalogserv.exceptions;// This is taken as Runtime, which is for scenarios where the exception is not expected to be recovered from

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}