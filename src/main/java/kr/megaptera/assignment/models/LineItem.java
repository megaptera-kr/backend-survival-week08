package kr.megaptera.assignment.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class LineItem {

//    @EmbeddedId
//    @Column(name ="lineItem_id")
//    private LineItemId id;

    @Id
    private String id;

    private String productName;

    private Long quantity;

    private Long totalPrice;

    private Long unitPrice;

    public LineItem() {
    }

    public LineItem(String id,String productName, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void update(Long quantity){
        this.quantity = quantity;
    }
    public String getProductName() {
        return productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(id, lineItem.id) && Objects.equals(productName, lineItem.productName) && Objects.equals(quantity, lineItem.quantity) && Objects.equals(totalPrice, lineItem.totalPrice) && Objects.equals(unitPrice, lineItem.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, quantity, totalPrice, unitPrice);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
