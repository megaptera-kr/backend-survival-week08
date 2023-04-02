package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Purchase;
import kr.megaptera.assignment.models.PurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, PurchaseId> {

    List<Purchase> findByAccountId(String accountId);

}
