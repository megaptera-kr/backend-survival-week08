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

    public ItemDto(Item item) {
        this(item.getId().toString(), item.getProductId().toString(), item.getColor(), item.getSize(),
                item.getStock(), item.getOriginalPrice(), item.getOnSalePrice());
    }

}
