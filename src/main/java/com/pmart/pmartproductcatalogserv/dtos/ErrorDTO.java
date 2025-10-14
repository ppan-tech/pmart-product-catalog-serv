package com.pmart.pmartproductcatalogserv.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO
{
    private String status;
    private String message;
}