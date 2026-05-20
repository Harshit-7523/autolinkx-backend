 package com.ecommerce.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.user_service.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}