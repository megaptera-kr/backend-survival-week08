package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartId> {
}
