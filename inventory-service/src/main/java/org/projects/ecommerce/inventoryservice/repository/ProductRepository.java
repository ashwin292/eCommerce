package org.projects.ecommerce.inventoryservice.repository;

import org.projects.ecommerce.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
