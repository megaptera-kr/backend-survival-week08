package kr.megaptera.assignment.applications.carts;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.domains.carts.CartItemId;
import kr.megaptera.assignment.infrastructures.CartRepository;
import kr.megaptera.assignment.presentations.dtos.carts.CartItemUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UpdateCartService {
    @Autowired
    private CartRepository cartRepository;

    public void update(String id, CartItemUpdateDto reqBody){
        var cartItem = cartRepository.getReferenceById(new CartItemId(id));
        cartItem.setQuantity(reqBody.getQuantity());
        cartRepository.save(cartItem);
    }
}
