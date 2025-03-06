package org.projects.ecommerce.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.projects.ecommerce.orderservice.dto.OrderRequestDto;
import org.projects.ecommerce.orderservice.entity.Orders;
import org.projects.ecommerce.orderservice.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper;

    public List<OrderRequestDto> getAllOrders() {
        log.info("Get all orders");
        List<Orders> orders = ordersRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).collect(Collectors.toList());
    }

    public OrderRequestDto getOrderById(Long id) {
        log.info("Get order by id {}", id);
        Orders order = ordersRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
        return modelMapper.map(order, OrderRequestDto.class);
    }

}
