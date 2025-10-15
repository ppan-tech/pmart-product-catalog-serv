package com.pmart.pmartproductcatalogserv.services;

import com.pmart.pmartproductcatalogserv.exceptions.ProductNotFoundException;
import com.pmart.pmartproductcatalogserv.models.Product;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        return null;
    }

    @Override
    public Product replaceProduct(long id, String name, String description, double price, String imageUrl, String category) {
        return null;
    }
}
