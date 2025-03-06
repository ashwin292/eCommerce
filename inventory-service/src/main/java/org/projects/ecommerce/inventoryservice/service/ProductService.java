package org.projects.ecommerce.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.projects.ecommerce.inventoryservice.dto.ProductDto;
import org.projects.ecommerce.inventoryservice.entity.Product;
import org.projects.ecommerce.inventoryservice.repository.ProductRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDto> getAllInventory() {
        log.info("getAllInventory");
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    public ProductDto getProductById(Long id) {
        log.info("getProductById");
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductDto.class);
    }
}
