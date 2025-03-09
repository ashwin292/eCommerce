package org.projects.ecommerce.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.projects.ecommerce.inventoryservice.dto.ProductDto;
import org.projects.ecommerce.inventoryservice.service.ProductService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    @GetMapping("/fetchOrders")
    public String fetchFromOrdersService() {
        ServiceInstance orderService = discoveryClient.getInstances("order-service").getFirst();
        return restClient.get().uri(orderService.getUri() + "/api/v1/orders/helloOrders")
                .retrieve().body(String.class);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllInventory() {
        return ResponseEntity.ok(productService.getAllInventory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        log.info("getProductById");
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
