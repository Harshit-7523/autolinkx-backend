 package com.ecommerce.user_service.dto;

import java.util.List;
import com.ecommerce.user_service.entity.OrderItem;

public class OrderResponse {

    private Long orderId;
    private double totalAmount;
    private List<OrderItem> items;

    public OrderResponse() {}

    public OrderResponse(Long orderId, double totalAmount, List<OrderItem> items) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}