package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class PurchaseItem {

    @EmbeddedId
    private PurchaseItemId id;

    private String accountId;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Purchase purchase;

    private Integer count;

    @CreatedDate
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public PurchaseItem(String accountId, Item item, Purchase purchase, Integer count) {
        this.id = PurchaseItemId.generate();
        this.accountId = accountId;
        this.item = item;
        this.purchase = purchase;
        this.count = count;
        this.orderStatus = OrderStatus.PAYMENT;
    }

}
