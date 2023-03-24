package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.Models.cart.*;
import org.springframework.data.jpa.repository.*;

public interface CartRepository extends JpaRepository<Cart, String> {
}
