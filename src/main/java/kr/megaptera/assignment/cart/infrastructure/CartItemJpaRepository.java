package kr.megaptera.assignment.cart.infrastructure;
import kr.megaptera.assignment.cart.domain.Cart;
import kr.megaptera.assignment.cart.domain.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartItemJpaRepository extends JpaRepository<Cart, CartId> {
    @Query("SELECT c FROM Cart c JOIN FETCH c.lineItems WHERE c.cartId = :cartId")
    Optional<Cart> findByIdWithLineItems(@Param("cartId") CartId cartId);
}
