package kr.megaptera.assignment.models.cart;

import kr.megaptera.assignment.exceptions.ItemNotFound;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    @Test
    void creation() {
        Cart cart = new Cart(CartId.of("TEST"));

        assertThat(cart.id().getId()).isEqualTo("TEST");
        assertThat(cart.lineItems().size()).isEqualTo(0);
    }

    @Test
    void changeItem() {
        Cart cart = new Cart(CartId.of("TEST"));
        assertThat(cart.lineItems().size()).isEqualTo(0);

        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));
        cart.addItem(product, 3);
        assertThat(cart.lineItems().size()).isEqualTo(1);

        Product product1 = new Product(ProductName.of("데자부"), Price.of(13000));
        cart.addItem(product1, 2);
        assertThat(cart.lineItems().size()).isEqualTo(2);

        cart.changeItemQuantity(product.id().getId(), 1);
        assertThat(cart.lineItems().size()).isEqualTo(2);
        Item changedItem = cart.lineItems()
                .stream()
                .filter(i -> i.getProduct().id().equals(product.id()))
                .findFirst()
                .orElseThrow(ItemNotFound::new);
        assertThat(changedItem.getQuantity().getValue()).isEqualTo(1);

        cart.removeItem(product1.id().getId());
        assertThat(cart.lineItems().size()).isEqualTo(1);
    }
}