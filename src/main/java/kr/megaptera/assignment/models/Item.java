package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Item {

    @EmbeddedId
    private ItemId id;

    @ManyToOne
    private Product product;

    private String color;

    private String size;

    private Integer stock;

    private Integer originalPrice;

    private Integer onSalePrice;

    private Integer shippingDays;

    public Item(Product product, String color, String size,
                Integer stock, Integer originalPrice, Integer onSalePrice, Integer shippingDays) {
        this.id = ItemId.generate();
        this.product = product;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.originalPrice = originalPrice;
        this.onSalePrice = onSalePrice;
        this.shippingDays = shippingDays;
    }

    public void update(Integer stock, Integer originalPrice, Integer onSalePrice, Integer shippingDays) {
        this.stock = stock;
        this.originalPrice = originalPrice;
        this.onSalePrice = onSalePrice;
        this.shippingDays = shippingDays;
    }
}
