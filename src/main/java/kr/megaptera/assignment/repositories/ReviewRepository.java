package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.Models.review.*;
import org.springframework.data.jpa.repository.*;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
