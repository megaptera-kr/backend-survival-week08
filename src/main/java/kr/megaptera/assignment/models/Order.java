package kr.megaptera.assignment.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Order {

    @EmbeddedId
    private OrderId id;

    private String recipientName;

    @Embedded
    private Address address;

    private String recipientPhone;

    private LocalDateTime date;

    private String userId;

}
