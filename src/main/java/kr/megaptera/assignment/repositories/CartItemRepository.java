package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.CartItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemId> {
}
