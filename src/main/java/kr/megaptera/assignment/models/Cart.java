package kr.megaptera.assignment.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Entity
@Table(name = "carts")
public class Cart {
    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "cart_id"))
    private CartId cartId;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "line_item_id")
    private List<LineItem> lineItemList = new ArrayList<>();

    protected Cart() {
    }

    protected Cart(CartId cartId) {
        this.cartId = cartId;
    }

    public static Cart getCart() {
        return new Cart(CartId.DEFAULT);
    }

    public CartId getCartId() {
        return cartId;
    }

    public List<LineItem> getLineItemList() {
        return lineItemList;
    }

    @Override
    public String toString() {
        return "Cart{" +
               "cartId=" + cartId +
               ", lineItemList=" + lineItemList +
               '}';
    }

    public void addLineItem(LineItem lineItem) {
        Predicate<LineItem> lineItemPredicate = i -> i.getProduct().getProductId().equals(lineItem.getProduct().getProductId());
        Optional<LineItem> old = lineItemList.stream()
                .filter(lineItemPredicate)
                .findFirst();
        if (old.isPresent()) {
            lineItemList.add(lineItem);
            lineItemList = lineItemList.stream()
                    .filter(lineItemPredicate)
                    .map(i -> LineItem.of(
                            i.getLineItemId(),
                            i.getProduct(),
                            i.getQuantity() + lineItem.getQuantity()
                    ))
                    .toList();
        } else {
            lineItemList.add(lineItem);
        }
    }

    public void setLineItemQuantity(LineItemId lineItemId, Long quantity) {
        Optional<LineItem> lineItemOptional = lineItemList.stream().filter(i -> i.getLineItemId().equals(lineItemId)).findFirst();
        if (quantity > 0) {
            lineItemOptional.ifPresent(lineItem -> lineItem.setQuantity(quantity));
        } else {
            lineItemList.remove(lineItemOptional.get());
        }
    }
}
