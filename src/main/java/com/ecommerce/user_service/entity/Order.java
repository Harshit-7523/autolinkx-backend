//package com.ecommerce.user_service.entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Long userId;
//
//    private Double totalAmount;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<OrderItem> items;
//
//    public Long getId() {
//        return id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public Double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public List<OrderItem> getItems() {
//        return items;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public void setTotalAmount(Double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public void setItems(List<OrderItem> items) {
//        this.items = items;
//    }
//}


package com.ecommerce.user_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Double totalAmount;

    // ✅ FIXED RELATION

    @OneToMany(cascade = CascadeType.ALL)

    @JoinColumn(name = "order_id")

    private List<OrderItem> items;

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}


















