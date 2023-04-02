package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import kr.megaptera.assignment.dtos.PurchaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

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

    private LocalDateTime orderDateTime;

    private LocalDateTime recipientDateTime;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> purchaseItems = new ArrayList<>();

    public Purchase(String accountId, String recipientName, Address address, String recipientPhone,
                    LocalDateTime orderDateTime, LocalDateTime recipientDateTime) {
        this.id = PurchaseId.generate();
        this.accountId = accountId;
        this.recipientName = recipientName;
        this.address = address;
        this.recipientPhone = recipientPhone;
        this.orderDateTime = orderDateTime;
        this.recipientDateTime = recipientDateTime;
    }

}
