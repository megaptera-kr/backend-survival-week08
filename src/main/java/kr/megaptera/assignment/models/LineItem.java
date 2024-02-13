package kr.megaptera.assignment.models;

import jakarta.persistence.*;

@Entity
public class LineItem {
    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "line_item_id"))
    private LineItemId lineItemId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    private Long quantity;

    protected LineItem() {
    }

    protected LineItem(LineItemId lineItemId, Product product, Long quantity) {
        this.lineItemId = lineItemId;
        this.product = product;
        this.quantity = quantity;
    }

    public static LineItem of(LineItemId lineItemId, Product product, Long quantity) {
        return new LineItem(
                lineItemId,
                product,
                quantity
        );
    }

    public static LineItem create(Product product, Long quantity) {
        return new LineItem(
                LineItemId.generate(),
                product,
                quantity
        );
    }

    public LineItemId getLineItemId() {
        return lineItemId;
    }

    public ProductName getProductName() {
        if (product != null) {
            return product.getProductName();
        }
        return null;
    }

    public Product getProduct() {
        return this.product;
    }


    public Long getQuantity() {
        return quantity;
    }

    public Price getUnitPrice() {
        if (product != null) {
            return product.getPrice();
        }
        return Price.zero();
    }

    public Price getTotalPrice() {
        return Price.of(getUnitPrice().getValue() * quantity);
    }

    @Override
    public String toString() {
        return "LineItem{" +
               "lineItemId=" + lineItemId +
               ", product=" + product +
               ", quantity=" + quantity +
               '}';
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
