package com.pmart.pmartproductcatalogserv.services;

import com.pmart.pmartproductcatalogserv.exceptions.ProductNotFoundException;
import com.pmart.pmartproductcatalogserv.models.Category;
import com.pmart.pmartproductcatalogserv.models.Product;
import com.pmart.pmartproductcatalogserv.repositories.CategoryRepository;
import com.pmart.pmartproductcatalogserv.repositories.ProductRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String name, String description, double price, String imageUrl, String category) {
        Product product = new Product();
        buildProduct(product, name, description, price, imageUrl, category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(long id, String name, String description, double price, String imageUrl, String category) {
        Product product = new Product();
        product.setId(id);
        buildProduct(product, name, description, price, imageUrl, category);

        return productRepository.save(product);
    }

    private void buildProduct(Product product, String name, String description, double price, String imageUrl, String category)
    {
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);

        Category categoryObj = getCategoryFromDataStore(category);
        product.setCategory(categoryObj);
    }
    private Category getCategoryFromDataStore(String categoryName)
    {
        //If category exists, return that else create a new category and return that.
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        if(categoryOptional.isPresent())
        {
            return categoryOptional.get();
        }

        Category newCategory = new Category();
        newCategory.setName(categoryName);

        return categoryRepository.save(newCategory);
    }


}
