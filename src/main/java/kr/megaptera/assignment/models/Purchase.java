package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import kr.megaptera.assignment.dtos.PurchaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Purchase {

    @EmbeddedId
    private PurchaseId id;

    @ColumnDefault("1")
    private String accountId;

    private String recipientName;

    @Embedded
    private Address address;

    private String recipientPhone;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime receiptedAt;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> purchaseItems = new ArrayList<>();

    public Purchase(String accountId, String recipientName, Address address, String recipientPhone, LocalDateTime receiptedAt) {
        this.id = PurchaseId.generate();
        this.accountId = accountId;
        this.recipientName = recipientName;
        this.address = address;
        this.recipientPhone = recipientPhone;
        this.receiptedAt = receiptedAt;
    }

}
