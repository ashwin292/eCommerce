package org.projects.ecommerce.inventoryservice.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;

    private String title;

    private Double price;

    private Integer quantity;
}
