package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.Models.product.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
    List<Product> findAllByUserId(String userId);
}
