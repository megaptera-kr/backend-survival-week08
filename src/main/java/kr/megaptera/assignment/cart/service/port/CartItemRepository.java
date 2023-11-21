package kr.megaptera.assignment.cart.domain;

import kr.megaptera.assignment.product.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {
    List<CartEntity> findAll();
    CartEntity save(CartEntity productEntity);
    Optional<CartEntity> findById(String id);
}
