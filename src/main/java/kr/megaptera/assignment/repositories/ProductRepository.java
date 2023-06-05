package kr.megaptera.assignment.repositories;


import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, ProductId> {
    List<Product> findAll();
}
