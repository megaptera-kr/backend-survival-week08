package kr.megaptera.assignment.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Item {

    @EmbeddedId
    private ItemId id;

    @AttributeOverride(name = "id", column = @Column(name = "productid"))
    private ProductId productId;

    private String color;

    private String size;

    private Integer stock;

    private Integer originalPrice;

    private Integer onSalePrice;

    public Item(ProductId productId, String color, String size,
                Integer stock, Integer originalPrice, Integer onSalePrice) {
        this.id = ItemId.generate();
        this.productId = productId;
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.originalPrice = originalPrice;
        this.onSalePrice = onSalePrice;
    }

    public void update(Integer stock, Integer originalPrice, Integer onSalePrice) {
        this.stock = stock;
        this.originalPrice = originalPrice;
        this.onSalePrice = onSalePrice;
    }
}
