package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {

    List<Review> findByProduct(Product product);


}
