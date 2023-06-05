package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, ProductId> {
    List<Cart> findAll();
}
