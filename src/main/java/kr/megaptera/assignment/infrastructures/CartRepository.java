package kr.megaptera.assignment.infrastructures;

import kr.megaptera.assignment.domains.carts.CartItem;
import kr.megaptera.assignment.domains.carts.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, CartItemId> {
}
