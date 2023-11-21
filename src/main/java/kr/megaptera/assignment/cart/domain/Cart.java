package kr.megaptera.assignment.cart.domain;

import com.github.f4b6a3.tsid.TsidCreator;
import jakarta.persistence.*;
import kr.megaptera.assignment.cart.dto.CartItem;
import kr.megaptera.assignment.cart.dto.CartLineItemRequest;
import kr.megaptera.assignment.product.domain.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
public class CartEntity {
    @Id
    private String id;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<CartItem> cartItems = new ArrayList<>();

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private Long unitPrice;

    public CartEntity(String name) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public CartEntity() {
    }

    public CartEntity(String id, List<ProductEntity> products, Long quantity, Long totalPrice, Long unitPrice) {
        this.id = id;
        this.products = products;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.unitPrice = unitPrice;
    }

    public CartItem toCartItem() {
        return new CartItem(
                this.getId(),
                this.getProducts(),
                this.getQuantity(),
                this.calculateTotalPrice(),
                this.getUnitPrice()
        );
    }

    // totalPrice 계산 메서드 (예시)
    private Long calculateTotalPrice() {
        return this.quantity * this.unitPrice;
    }

    public void addProduct(ProductEntity product, long quantity) {
        CartItem existingItem = this.items.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            // 상품이 이미 있다면, 수량을 업데이트
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            // 상품이 없다면, 새로운 상품 추가
            this.products.add(product);
            product.setQuantity(quantity);
        }

        // 총 가격을 재계산
        recalculateTotalPrice();
    }

    private void recalculateTotalPrice() {
        long total = 0;
        for (ProductEntity product : this.products) {
            total += product.getUnitPrice() * product.getQuantity();
        }
        this.totalPrice = total;
    }
