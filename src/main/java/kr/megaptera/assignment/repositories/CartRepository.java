package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, CartId> {
}
