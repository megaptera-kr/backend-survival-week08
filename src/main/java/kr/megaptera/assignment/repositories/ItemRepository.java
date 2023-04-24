package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Item;
import kr.megaptera.assignment.models.ItemId;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, ItemId> {

    List<Item> findByProductId(ProductId productId);

}
