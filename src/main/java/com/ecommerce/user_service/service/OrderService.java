package com.ecommerce.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user_service.entity.Cart;
import com.ecommerce.user_service.entity.Order;
import com.ecommerce.user_service.entity.OrderItem;
import com.ecommerce.user_service.entity.Product;
import com.ecommerce.user_service.repository.CartRepository;
import com.ecommerce.user_service.repository.OrderRepository;
import com.ecommerce.user_service.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    // ✅ PLACE ORDER

    public Order placeOrder(Long userId) {

        // ✅ GET USER CART

        List<Cart> cartItems =
                cartRepository.findByUserId(userId);

        // ✅ EMPTY CART CHECK

        if (cartItems.isEmpty()) {

            throw new RuntimeException("Cart is empty");
        }

        double total = 0;

        List<OrderItem> orderItems =
                new ArrayList<>();

        // ✅ CART → ORDER ITEMS

        for (Cart c : cartItems) {

            Product product =
                    productRepository
                            .findById(c.getProductId())
                            .orElseThrow(() ->
                                    new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();

            item.setProductId(product.getId());

            item.setProductName(product.getName());

            item.setPrice(product.getPrice());

            item.setQuantity(c.getQuantity());

            total +=
                    product.getPrice() * c.getQuantity();

            orderItems.add(item);
        }

        // ✅ CREATE ORDER

        Order order = new Order();

        order.setUserId(userId);

        order.setTotalAmount(total);

        order.setItems(orderItems);

        // ✅ SAVE ORDER

        Order savedOrder =
                orderRepository.save(order);

        // ✅ CLEAR CART

        cartRepository.deleteAll(cartItems);

        return savedOrder;
    }

    // ✅ GET USER ORDERS

    public List<Order> getOrders(Long userId) {

        return orderRepository.findByUserId(userId);
    }
}