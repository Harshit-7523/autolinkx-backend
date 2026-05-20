package com.ecommerce.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.user_service.dto.CartResponse;
import com.ecommerce.user_service.entity.Cart;
import com.ecommerce.user_service.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    @Autowired
    private CartService cartService;

    // ✅ Add To Cart
    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {

        return cartService.addToCart(cart);
    }

    // ✅ Get Cart
    @GetMapping("/{userId}")
    public List<CartResponse> getCart(@PathVariable Long userId) {

        return cartService.getCartByUser(userId);
    }

    // ✅ Increase Quantity
    @PutMapping("/increase/{id}")
    public Cart increaseQuantity(@PathVariable Long id) {

        return cartService.increaseQuantity(id);
    }

    // ✅ Decrease Quantity
    @PutMapping("/decrease/{id}")
    public Cart decreaseQuantity(@PathVariable Long id) {

        return cartService.decreaseQuantity(id);
    }

    // ✅ Delete Cart Item
    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id) {

        cartService.deleteCart(id);
    }
}