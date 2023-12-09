package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.CartLineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineItemRepository extends CrudRepository<CartLineItem, Long> {
}
