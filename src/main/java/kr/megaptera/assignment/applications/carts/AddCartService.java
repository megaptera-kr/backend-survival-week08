package kr.megaptera.assignment.applications.carts;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.domains.carts.CartItem;
import kr.megaptera.assignment.domains.carts.CartItemId;
import kr.megaptera.assignment.domains.products.ProductId;
import kr.megaptera.assignment.exceptions.ProductNotFoundException;
import kr.megaptera.assignment.infrastructures.CartRepository;
import kr.megaptera.assignment.infrastructures.ProductRepository;
import kr.megaptera.assignment.presentations.dtos.carts.CartItemAddDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AddCartService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    public void add(CartItemAddDto reqBody){
        var productId = new ProductId(reqBody.getProductId());
        var product = productRepository.getReferenceById(productId);
        if(product == null){
            throw new ProductNotFoundException();
        }

        var cartItem = new CartItem(new CartItemId(), product, reqBody.getQuantity());
        cartRepository.save(cartItem);
    }
}
