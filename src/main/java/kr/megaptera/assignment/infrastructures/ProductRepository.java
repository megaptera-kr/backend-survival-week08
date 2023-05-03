package kr.megaptera.assignment.infrastructures;

import kr.megaptera.assignment.domains.products.Product;
import kr.megaptera.assignment.domains.products.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    Product getReferenceByName(String name);
}
