package kr.megaptera.assignment.presentations;

import kr.megaptera.assignment.applications.carts.AddCartService;
import kr.megaptera.assignment.applications.carts.GetCartItemsService;
import kr.megaptera.assignment.applications.carts.UpdateCartService;
import kr.megaptera.assignment.presentations.dtos.carts.CartItemAddDto;
import kr.megaptera.assignment.presentations.dtos.carts.CartItemUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-line-items")
public class CartItemController {
    @Autowired
    private GetCartItemsService getCartItemsService;

    @Autowired
    private AddCartService addCartService;

    @Autowired
    private UpdateCartService updateCartService;

    @GetMapping
    public ResponseEntity findAll() {
        var productDtos = getCartItemsService.getAll();
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CartItemAddDto reqBody){
        addCartService.add(reqBody);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable String id,
            @RequestBody CartItemUpdateDto reqBody){
        updateCartService.update(id, reqBody);
    }
}
