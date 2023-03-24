package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.Models.product.*;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
