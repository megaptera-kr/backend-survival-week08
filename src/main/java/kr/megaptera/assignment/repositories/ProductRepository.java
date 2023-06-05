package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, ProductId> {
    List<Product> findAll();
}
