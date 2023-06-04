package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.dtos.CartListItemDto;
import kr.megaptera.assignment.dtos.CartPatchDto;
import kr.megaptera.assignment.dtos.CartPostDto;
import kr.megaptera.assignment.dtos.ItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart-line-items")
@RestController
public class CartController {

    @GetMapping
    public CartListItemDto getCartLineItems() {
        return null;
    }

    @PostMapping
    public ItemDto postCartLineItem(
            @RequestBody CartPostDto cartPostDto
    ) {
        return null;
    }

    @PatchMapping("/{id}")
    public ItemDto patchCartLineItem(
            @PathVariable String id,
            @RequestBody CartPatchDto cartPatchDto
    ) {
        return null;
    }
}
