package kr.megaptera.assignment.cart.domain;

import jakarta.persistence.*;
import kr.megaptera.assignment.cart.domain.CartId;
import kr.megaptera.assignment.cart.domain.LineItem;
import kr.megaptera.assignment.cart.domain.LineItemId;
import kr.megaptera.assignment.cart.dto.CartResponse;
import kr.megaptera.assignment.cart.dto.LineItemResponse;
import kr.megaptera.assignment.product.domain.Product;
import kr.megaptera.assignment.product.domain.ProductId;
import kr.megaptera.assignment.product.dto.ProductResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "carts")
public class Cart {
    @EmbeddedId
    private CartId cartId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id")
    @OrderBy("id")
    private List<LineItem> lineItems = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Cart() {
    }

    public Cart(CartId cartId) {
        this.cartId = cartId;
    }

    public Cart(CartId cartId, List<LineItem> lineItems) {
        this.cartId = cartId;
        this.lineItems = lineItems;
    }

    public void addProduct(Product product, Long quantity) {
        if (quantity <= 0) {
            return;
        }

        Optional<LineItem> found = findLineItem(product.id());

        if (found.isPresent()) {
            LineItem lineItem = found.get();
            lineItem.increaseQuantity(quantity.intValue());
            return;
        }

        LineItem lineItem = LineItem.create(product, quantity.intValue());

        lineItems.add(lineItem);
    }

    public void changeLineItemQuantity(LineItemId lineItemId, Long quantity) {
        LineItem lineItem = findLineItem(lineItemId).get();

        if (quantity <= 0) {
            lineItems.remove(lineItem);
            return;
        }

        lineItem.changeQuantity(quantity.intValue());
    }

    public int lineItemsSize() {
        return lineItems.size();
    }

    public LineItem lineItem(int index) {
        return lineItems.get(index);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public Optional<LineItem> findLineItem(ProductId productId) {
        return lineItems.stream()
                .filter(item -> item.sameProduct(productId))
                .findFirst();
    }

    public Optional<LineItem> findLineItem(LineItemId lineItemId) {
        return lineItems.stream()
                .filter(item -> item.id().equals(lineItemId))
                .findFirst();
    }
    public CartResponse toResponse() {
        System.out.println(lineItems);
        List<LineItemResponse> lineItemResponses = lineItems.stream()
                .map(lineItem -> new LineItemResponse(
                        lineItem.getId().toString(),
                        lineItem.getProductName(),
                        lineItem.getQuantity(),
                        lineItem.getUnitPrice().getValue(),
                        lineItem.getTotalPrice().getValue()
                ))
                .toList();
        return new CartResponse(lineItemResponses);
    }
}