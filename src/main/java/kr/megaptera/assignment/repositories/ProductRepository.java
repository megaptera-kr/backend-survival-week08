package kr.megaptera.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;

public interface ProductRepository extends CrudRepository<Product, ProductId> {
    List<Product> findAll();
}
