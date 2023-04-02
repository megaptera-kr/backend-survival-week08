package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartDto;
import kr.megaptera.assignment.dtos.ItemDto;
import kr.megaptera.assignment.dtos.PurchaseDto;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.ItemRepository;
import kr.megaptera.assignment.repositories.PurchaseItemRepository;
import kr.megaptera.assignment.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final ItemRepository itemRepository;

    private final PurchaseRepository purchaseRepository;

    private final PurchaseItemRepository purchaseItemRepository;

    public List<PurchaseDto> getPurchasesByAccount(String accountId) {
        List<Purchase> purchasesByAccount = purchaseRepository.findByAccountId(accountId);
        return purchasesByAccount.stream().map(purchase -> new PurchaseDto(purchase)).toList();
    }

    public Purchase requestPurchase(String accountId, PurchaseDto purchaseDto, List<CartDto> carts) {
        Purchase purchase = new Purchase(purchaseDto.getAccountId(), purchaseDto.getRecipientName(),
                purchaseDto.getAddress(), purchaseDto.getRecipientPhone(),
                purchaseDto.getOrderDateTime(), purchaseDto.getRecipientDateTime());

        purchase = purchaseRepository.save(purchase);

        for ( CartDto cartDto : carts ) {
            Item item = itemRepository.findById(ItemId.of(cartDto.getItemId())).orElseThrow();
            PurchaseItem purchaseItem = new PurchaseItem(accountId, item, purchase, cartDto.getCount());
            purchaseItemRepository.save(purchaseItem);
        }

        return purchase;
    }

    public PurchaseItem cancelPurchase(PurchaseItemId purchaseItemId) {
        PurchaseItem purchaseItem = purchaseItemRepository.findById(purchaseItemId).orElseThrow();

        if ( purchaseItem.getOrderStatus().equals(OrderStatus.PAYMENT) ) {
            purchaseItemRepository.delete(purchaseItem);
        }

        Purchase purchase = purchaseItem.getPurchase();

        if ( purchaseItemRepository.countByPurchase(purchase) == 0L ) {
            purchaseRepository.delete(purchase);
        }

        return purchaseItem;
    }
}
