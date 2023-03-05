package com.demoApp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private double price;

    @NotEmpty
    private String category;

    @NotEmpty
    private String imagePath;
}
