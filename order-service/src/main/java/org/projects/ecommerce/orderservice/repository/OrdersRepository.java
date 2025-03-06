package org.projects.ecommerce.orderservice.repository;

import org.projects.ecommerce.orderservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
