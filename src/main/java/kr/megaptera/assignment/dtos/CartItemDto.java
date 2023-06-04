package kr.megaptera.assignment.dtos;

import jakarta.persistence.ManyToOne;
import kr.megaptera.assignment.models.Product;

public class CartItemDto {
    private Long id;

    private Product product;

    private int quantity;

    public CartItemDto() {
    }

    public CartItemDto(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
