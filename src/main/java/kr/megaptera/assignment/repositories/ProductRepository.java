package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
