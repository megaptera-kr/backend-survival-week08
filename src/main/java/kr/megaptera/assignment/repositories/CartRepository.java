package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.lineItems.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
