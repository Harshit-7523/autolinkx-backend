package com.ecommerce.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user_service.entity.Cart;
import com.ecommerce.user_service.entity.Product;
import com.ecommerce.user_service.repository.CartRepository;
import com.ecommerce.user_service.repository.ProductRepository;
import com.ecommerce.user_service.dto.CartResponse;

import java.util.*;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // ✅ Add To Cart
    public Cart addToCart(Cart cart) {

        List<Cart> existingItems =
                cartRepository.findByUserId(cart.getUserId());

        for (Cart item : existingItems) {

            if (item.getProductId().equals(cart.getProductId())) {

                item.setQuantity(
                        item.getQuantity() + cart.getQuantity()
                );

                return cartRepository.save(item);
            }
        }

        return cartRepository.save(cart);
    }

    // ✅ Get Cart
    public List<CartResponse> getCartByUser(Long userId) {

        List<Cart> cartList =
                cartRepository.findByUserId(userId);

        List<CartResponse> response =
                new ArrayList<>();

        for (Cart c : cartList) {

            Product p =
                    productRepository.findById(c.getProductId())
                            .orElse(null);

            if (p == null) {
                continue;
            }

            CartResponse cr = new CartResponse();

            cr.setId(c.getId());

            cr.setProductName(p.getName());

            cr.setPrice(p.getPrice());

            cr.setQuantity(c.getQuantity());

            response.add(cr);
        }

        return response;
    }

    // ✅ Increase Quantity
    public Cart increaseQuantity(Long id) {

        Cart cart =
                cartRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Cart not found"));

        cart.setQuantity(cart.getQuantity() + 1);

        return cartRepository.save(cart);
    }

    // ✅ Decrease Quantity
    public Cart decreaseQuantity(Long id) {

        Cart cart =
                cartRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Cart not found"));

        if (cart.getQuantity() > 1) {

            cart.setQuantity(cart.getQuantity() - 1);

            return cartRepository.save(cart);
        }

        return cart;
    }

    // ✅ Delete Cart
    public void deleteCart(Long id) {

        cartRepository.deleteById(id);
    }
}