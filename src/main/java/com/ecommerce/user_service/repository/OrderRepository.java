 package com.ecommerce.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.user_service.entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}