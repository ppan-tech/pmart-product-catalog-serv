package com.pmart.pmartproductcatalogserv.services;

import com.pmart.pmartproductcatalogserv.models.Category;
import com.pmart.pmartproductcatalogserv.models.Product;

import java.util.List;

public interface CatalogService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
}
