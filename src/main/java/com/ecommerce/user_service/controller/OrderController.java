package com.ecommerce.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user_service.entity.Order;
import com.ecommerce.user_service.service.OrderService;

import java.util.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ✅ PLACE ORDER

    @PostMapping("/place/{userId}")
    public Order placeOrder(@PathVariable Long userId) {

        return orderService.placeOrder(userId);
    }

    // ✅ GET USER ORDERS

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {

        return orderService.getOrders(userId);
    }
}