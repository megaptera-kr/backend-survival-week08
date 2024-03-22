package repository;

import models.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartItem, String> {
}
