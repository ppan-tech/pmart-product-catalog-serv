package com.pmart.pmartproductcatalogserv.dtos;

import com.pmart.pmartproductcatalogserv.models.Category;
import com.pmart.pmartproductcatalogserv.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO
{
    private long id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private String category;

    public static ProductResponseDTO from(Product product)
    {
        if(product == null)
        {
            return null;
        }
        ProductResponseDTO productResponseDto = new ProductResponseDTO();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setCategory(product.getCategory().getName());

        return productResponseDto;
    }
}