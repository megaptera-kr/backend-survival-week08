package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.PurchaseService;
import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.PurchaseDto;
import kr.megaptera.assignment.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public List<PurchaseDto> getPurchasesByAccount(@RequestAttribute String accountId) {
        List<PurchaseDto> purchasesByAccount = purchaseService.getPurchasesByAccount(accountId);
        log.info("Purchase List of User " + accountId + " is loaded.");
        return purchasesByAccount;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase requestPurchase(@RequestAttribute String accountId, @RequestBody PurchaseDto purchaseDto,
                                    @RequestBody List<CartDto> carts) {
        Purchase purchase = purchaseService.requestPurchase(accountId, purchaseDto, carts);
        log.info("Items in cart" + carts.toString() + " are ordered by User " + accountId + ".");
        return purchase;
    }

    @DeleteMapping("/{purchaseItemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public PurchaseItem cancelPurchase(@PathVariable PurchaseItemId purchaseItemId) {
        PurchaseItem purchaseItem = purchaseService.cancelPurchase(purchaseItemId);
        return purchaseItem;
    }

}
