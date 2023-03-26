package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {

}
