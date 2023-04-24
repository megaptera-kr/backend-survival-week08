package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Item;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private String id;

    private String productId;

    private String color;

    private String size;

    private Integer stock;

    private Integer originalPrice;

    private Integer onSalePrice;

    private Integer shippingDays;

    public ItemDto(Item item) {
        this(item.getId().toString(), item.getProduct().getId().toString(), item.getColor(), item.getSize(),
                item.getStock(), item.getOriginalPrice(), item.getOnSalePrice(), item.getShippingDays());
    }

}
