package kr.megaptera.assignment.product.infrastructure;

import kr.megaptera.assignment.product.domain.ProductEntity;
import kr.megaptera.assignment.product.dto.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,String> {
}
