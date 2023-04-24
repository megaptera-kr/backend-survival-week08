package kr.megaptera.assignment.model;

public class CartItem {
  private CartItemId id;
  private ProductId productId;
  private ProductName productName;
  private Quantity quantity;
  private UnitPrice unitPrice;

  public CartItem(CartItemId id, ProductId productId, ProductName productName, Quantity quantity,
                  UnitPrice unitPrice) {
    this.id = id;
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
  }

  public static CartItem createCartItem(Product product) {
    CartItemId cartItemId = CartItemId.generate();
    return new CartItem(cartItemId, product.getId(), product.getProductName(), new Quantity(1),
        product.getUnitPrice());
  }

  public CartItemId getId() {
    return id;
  }

  public ProductId getProductId() {
    return productId;
  }

  public ProductName getProductName() {
    return productName;
  }

  public Quantity getQuantity() {
    return quantity;
  }

  public void increaseQuantity() {
    this.quantity = new Quantity(this.getQuantity().getValue() + 1);
  }

  public void decreaseQuantity() {
    this.quantity = new Quantity(this.getQuantity().getValue() - 1);
  }


  public UnitPrice getUnitPrice() {
    return unitPrice;
  }

  @Override
  public String toString() {
    return "CartItem{" +
        "id=" + id +
        ", productId=" + productId +
        ", productName=" + productName +
        ", quantity=" + quantity +
        ", unitPrice=" + unitPrice +
        '}';
  }
}
