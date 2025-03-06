package org.projects.ecommerce.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.projects.ecommerce.orderservice.dto.OrderRequestDto;
import org.projects.ecommerce.orderservice.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<OrderRequestDto>> getAllOrders() {
        return ResponseEntity.ok().body(ordersService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ordersService.getOrderById(id));
    }
}
