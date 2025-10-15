package com.pmart.pmartproductcatalogserv.services;

import com.pmart.pmartproductcatalogserv.exceptions.ProductNotFoundException;
import com.pmart.pmartproductcatalogserv.models.Product;

import java.util.List;

public interface ProductService
{
    Product getProductById(long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(String name, String description, double price, String imageUrl, String category);
    Product replaceProduct(long id, String name, String description, double price, String imageUrl, String category);

}