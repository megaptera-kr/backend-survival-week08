package kr.megaptera.assignment.cart.service.port;
import kr.megaptera.assignment.cart.domain.Cart;
import kr.megaptera.assignment.cart.domain.CartId;
import kr.megaptera.assignment.cart.domain.LineItem;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {
    List<Cart> findAll();
    Cart save(Cart cart);
    Optional<Cart> findById(CartId id);
    Optional<Cart> findByIdWithLineItems(CartId id);

}