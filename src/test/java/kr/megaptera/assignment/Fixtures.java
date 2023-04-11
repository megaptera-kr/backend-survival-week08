package kr.megaptera.assignment;

import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;

public class Fixtures {

    public static Product product() {
        return product(1);
    }

    private static Product product(int number) {
        ProductId productId = new ProductId("012340000000" + number);
        return new Product(productId, "Test Product", "Test", "Test Brand",
                "Test Category", "Test SubCategory");
    }

}
