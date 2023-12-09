package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.UpdateCartLineItemsInput;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private CartLineItem cartLineItem;

    public Product(CreateProductDto createProductDto) {
        this.name = createProductDto.getName();
        this.price = createProductDto.getPrice();
    }

    public Product() {

    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Long price() {
        return price;
    }

    public CartLineItem cartLineItem() {
        return cartLineItem;
    }

    public void updateCartLineItem(UpdateCartLineItemsInput updateCartLineItemsInput) {
        if (updateCartLineItemsInput.getQuantity() <= 0) {
            this.cartLineItem = null;
        } else {
            cartLineItem.setQuantity(updateCartLineItemsInput.getQuantity());
        }
    }
}
