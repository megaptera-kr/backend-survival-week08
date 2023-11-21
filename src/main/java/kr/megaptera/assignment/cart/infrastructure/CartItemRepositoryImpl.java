package kr.megaptera.assignment.cart.infrastructure;

import kr.megaptera.assignment.cart.domain.Cart;
import kr.megaptera.assignment.cart.domain.CartId;
import kr.megaptera.assignment.cart.service.port.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartItemRepositoryImpl implements CartItemRepository {
    private final CartItemJpaRepository cartItemJpaRepository;

    @Autowired
    public CartItemRepositoryImpl(CartItemJpaRepository cartItemJpaRepository) {
        this.cartItemJpaRepository = cartItemJpaRepository;
    }

    @Override
    public List<Cart> findAll() {
        return cartItemJpaRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(CartId id) {
        return cartItemJpaRepository.findById(id);
    }

    @Override
    public Optional<Cart> findByIdWithLineItems(CartId id) {
        return cartItemJpaRepository.findByIdWithLineItems(id);
    }

    @Override
    public Cart save(Cart cartEntity) {
        return cartItemJpaRepository.save(cartEntity);
    }

}
