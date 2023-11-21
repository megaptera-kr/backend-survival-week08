package kr.megaptera.assignment.product.infrastructure;

import kr.megaptera.assignment.product.domain.Product;
import kr.megaptera.assignment.product.domain.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, ProductId> {
}
