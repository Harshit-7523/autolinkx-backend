//package com.ecommerce.user_service.repository;
//
//public class ProductRepository {
//
//}


package com.ecommerce.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.user_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}