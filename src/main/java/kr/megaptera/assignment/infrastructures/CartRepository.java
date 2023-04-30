package kr.megaptera.assignment.infrastructures;

import kr.megaptera.assignment.domains.carts.CartItem;
import kr.megaptera.assignment.domains.carts.CartItemId;
import kr.megaptera.assignment.domains.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, CartItemId> {
    CartItem getReferenceByProduct(Product product);
}
