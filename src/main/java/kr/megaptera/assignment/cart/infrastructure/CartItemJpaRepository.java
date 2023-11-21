package kr.megaptera.assignment.cart.infrastructure;

import kr.megaptera.assignment.cart.domain.CartEntity;
import kr.megaptera.assignment.cart.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartEntity, String> {
}
