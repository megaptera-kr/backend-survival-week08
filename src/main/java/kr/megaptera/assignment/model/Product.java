package kr.megaptera.assignment.model;

public class Product {
  private ProductId id;
  private ProductName productName;
  private UnitPrice unitPrice;

  private Product(ProductId id, ProductName productName, UnitPrice unitPrice) {
    this.id = id;
    this.productName = productName;
    this.unitPrice = unitPrice;
  }

  public static Product createProduct(String name, int unitPrice) {
    return new Product(ProductId.generate(), new ProductName(name), new UnitPrice(unitPrice));
  }

  public ProductId getId() {
    return id;
  }

  public ProductName getProductName() {
    return productName;
  }

  public UnitPrice getUnitPrice() {
    return unitPrice;
  }
}
