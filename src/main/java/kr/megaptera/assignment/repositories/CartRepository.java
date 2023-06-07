package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.cart.Cart;
import kr.megaptera.assignment.models.cart.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}
