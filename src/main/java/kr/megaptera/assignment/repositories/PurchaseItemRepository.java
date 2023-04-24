package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Purchase;
import kr.megaptera.assignment.models.PurchaseItem;
import kr.megaptera.assignment.models.PurchaseItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, PurchaseItemId> {

    Long countByPurchase(Purchase purchase);

}
