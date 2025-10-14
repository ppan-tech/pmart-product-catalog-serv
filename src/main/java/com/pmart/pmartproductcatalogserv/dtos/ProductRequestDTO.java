package com.pmart.pmartproductcatalogserv.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private String category;
}
