package com.pmart.pmartproductcatalogserv.controllers;

import com.pmart.pmartproductcatalogserv.dtos.ProductRequestDTO;
import com.pmart.pmartproductcatalogserv.dtos.ProductResponseDTO;
import com.pmart.pmartproductcatalogserv.exceptions.ProductNotFoundException;
import com.pmart.pmartproductcatalogserv.models.Product;
import com.pmart.pmartproductcatalogserv.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pmart-products/v1")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") long id)
            throws ProductNotFoundException
    {

        Product product = productService.getProductById(id);

        return ProductResponseDTO.from(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts()
    {
        List<Product> products = productService.getAllProducts();

       /* List<ProductResponseDTO> productResponseDtos = new ArrayList<>();
        for(Product product : products)
        {
            ProductResponseDTO productResponseDto = ProductResponseDTO.from(product);
            productResponseDtos.add(productResponseDto);
        }*/

        List<ProductResponseDTO> productResponseDtos =
                products.stream().map(ProductResponseDTO::from)
                        .collect(Collectors.toList());
        return productResponseDtos;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody ProductRequestDTO productRequestDTO)
    {
        Product product = productService.createProduct(
                productRequestDTO.getName(),
                productRequestDTO.getDescription(),
                productRequestDTO.getPrice(),
                productRequestDTO.getImageUrl(),
                productRequestDTO.getCategory()
        );
        return new ResponseEntity<>(ProductResponseDTO.from(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> replaceProduct(@PathVariable("id") long id,
                                             @RequestBody ProductRequestDTO productRequestDTO)
    {
        Product product = productService.replaceProduct(
                id,
                productRequestDTO.getName(),
                productRequestDTO.getDescription(),
                productRequestDTO.getPrice(),
                productRequestDTO.getImageUrl(),
                productRequestDTO.getCategory()
        );

        return new ResponseEntity<>(ProductResponseDTO.from(product), HttpStatus.OK);
    }


}
