package com.ecommerce.user_service.entity;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long productId;   // ✅ ये ADD करो

    private int quantity;

    // ✅ getters setters

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {   // 🔥 यही missing था
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProductId(Long productId) {   // 🔥 important
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}