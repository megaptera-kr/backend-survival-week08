package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ItemService;
import kr.megaptera.assignment.dtos.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products/{productId}/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<ItemDto> getItemsByProduct(@PathVariable String productId) {
        List<ItemDto> itemDtos = itemService.getItemsByProductId(productId);
        return itemDtos;
    }

    @GetMapping("/{id}")
    public ItemDto getItem(@PathVariable String id) {
        ItemDto itemDto = itemService.getItem(id);
        return itemDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody ItemDto ItemDto) {
        ItemDto createdItemDto = itemService.addItem(ItemDto);
        return createdItemDto;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ItemDto updateItem(@PathVariable String id, @RequestBody ItemDto ItemDto) {
        ItemDto updatedItemDto = itemService.updateItem(id, ItemDto);
        return updatedItemDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ItemDto removeItem(@PathVariable String id) {
        ItemDto deletedItemDto = itemService.removeItem(id);
        return deletedItemDto;
    }

}
