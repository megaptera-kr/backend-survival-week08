package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.dtos.CartLineItemDetailListDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart-lint-items")
public class CartLineItemsController {
    public CartLineItemDetailListDto list() {

    }
}
