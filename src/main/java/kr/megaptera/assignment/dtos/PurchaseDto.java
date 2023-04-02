package kr.megaptera.assignment.dtos;

import jakarta.persistence.*;
import kr.megaptera.assignment.models.Address;
import kr.megaptera.assignment.models.Purchase;
import kr.megaptera.assignment.models.PurchaseItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {

    private String id;

    private String accountId;

    private String recipientName;

    private Address address;

    private String recipientPhone;

    private LocalDateTime orderDateTime;

    private LocalDateTime recipientDateTime;

    public PurchaseDto(Purchase purchase) {
        this(purchase.getId().toString(), purchase.getAccountId(), purchase.getRecipientName(),
                purchase.getAddress(), purchase.getRecipientPhone(), purchase.getOrderDateTime(),
                purchase.getRecipientDateTime());
    }

}

