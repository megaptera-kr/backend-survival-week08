package models;

import dtos.CartInsertDto;
import dtos.CartUpdateDto;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class CartItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private long quantity;

    public CartItem(CartInsertDto cartInsertDto) {
        this.product = new Product(cartInsertDto.getId());
        this.quantity = cartInsertDto.getQuantity();
    }

    public CartItem() {
    }

    public CartItem(Product product, long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem(CartUpdateDto dto) {
        this.product = new Product(dto.getId());
        this.quantity = dto.getQuantity();
    }

    public Product product() {
        return product;
    }

    public long quantity() {
        return quantity;
    }
}
