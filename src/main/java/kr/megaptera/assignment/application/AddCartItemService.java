package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.request.RqPostCartItemDto;
import kr.megaptera.assignment.models.Cart;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCartItemService {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public AddCartItemService(ProductRepository productRepository,
                              CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public String addCartItem(RqPostCartItemDto dto) {

        Product product = productRepository.findById(ProductId.of(dto.getProductId()))
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        Cart cart = Cart.of(product.Name(), dto.getQuantity(), product.Price() * dto.getQuantity(), product.Price());

        cartRepository.save(cart);

        return "";
    }

}
