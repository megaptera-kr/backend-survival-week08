package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import kr.megaptera.assignment.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {

    List<Cart> findByAccountId(String accountId);

    Cart findByItem(Item item);
}
