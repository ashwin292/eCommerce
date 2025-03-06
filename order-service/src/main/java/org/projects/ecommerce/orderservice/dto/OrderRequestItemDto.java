package org.projects.ecommerce.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequestItemDto {
    private Long itemId;
    private Long productId;
    private Integer quantity;
}
