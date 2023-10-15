package kr.megaptera.assignment.repositories;

import org.springframework.data.repository.CrudRepository;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.CartId;

public interface CartRepository extends CrudRepository<Cart, CartId> {
}
