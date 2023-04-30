package kr.megaptera.assignment.domains.carts;

import jakarta.persistence.*;
import kr.megaptera.assignment.domains.products.Product;
import kr.megaptera.assignment.domains.products.ProductId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @EmbeddedId
    private CartItemId id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private long quantity;
}
