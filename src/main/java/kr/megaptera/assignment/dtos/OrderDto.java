package kr.megaptera.assignment.dtos;

import jakarta.persistence.*;
import kr.megaptera.assignment.models.Address;
import kr.megaptera.assignment.models.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String id;

    private String recipientName;

    @Embedded
    private Address address;

    private String recipientPhone;

    private LocalDateTime orderDateTime;

    private LocalDateTime recipientDateTime;

    private String userId;

    private List<OrderItem> orderItems = new ArrayList<>();

}

