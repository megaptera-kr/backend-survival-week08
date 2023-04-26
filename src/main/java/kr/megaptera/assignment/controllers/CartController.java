package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.*;
import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/cart-line-items")
public class CartController {

    private GetLineItemsService getLineItemsService;
    private CreateLineItemService createLineItemService;
    private UpdateLineItemsService updateLineItemsService;

    public CartController(GetLineItemsService getLineItemsService, CreateLineItemService createLineItemService, UpdateLineItemsService updateLineItemsService) {
        this.getLineItemsService = getLineItemsService;
        this.createLineItemService = createLineItemService;
        this.updateLineItemsService = updateLineItemsService;
    }

    @GetMapping
    public Map<String, List<LineItemDto>> list() {
        Map<String, List<LineItemDto>> lineItemMap = new HashMap<>();
        List<LineItemDto> lineItems = getLineItemsService.getLineItemDtos();
        lineItemMap.put("lineItems", lineItems);
        return lineItemMap;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LineItemCreateDto lineItemCreateDto) {
        createLineItemService.createlineItem(lineItemCreateDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody LineItemUpdateDto lineItemUpdateDto) {
        updateLineItemsService.updatelineItem(id, lineItemUpdateDto);
    }

    @ExceptionHandler(LineItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String LineItemNotFound() {
        return"해당 물건이 없슴둥!";
    }
}
