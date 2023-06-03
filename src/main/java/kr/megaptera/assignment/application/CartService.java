package kr.megaptera.assignment.application;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.CreateCartDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {


    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public void createCart(CreateCartDto dto) {
        Optional<Product> opProduct = productRepository.findById(ProductId.of(dto.getProductId()));
        if (opProduct == null) {
            throw new ProductNotFound();
        }
        Cart cart = new Cart(opProduct.get().id(), opProduct.get().productName(), dto.getQuantity(), opProduct.get().productPrice());
        cartRepository.save(cart);
    }

    public List<CartDto> getCartLists() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map(cart -> new CartDto(cart)).toList();
    }

    public void updateQuantity(CartDto cartDto, String id) {
        Optional<Cart> cart = cartRepository.findById(ProductId.of(id));
        cart.get().updateQuantity(cartDto.getQuantity());
    }
}
