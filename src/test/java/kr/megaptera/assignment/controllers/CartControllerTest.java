package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateCartService;
import kr.megaptera.assignment.application.GetCartService;
import kr.megaptera.assignment.application.UpdateCartService;
import kr.megaptera.assignment.dtos.CartListItemDto;
import kr.megaptera.assignment.dtos.CartPostDto;
import kr.megaptera.assignment.dtos.CartUpdateDto;
import kr.megaptera.assignment.dtos.ItemDto;
import kr.megaptera.assignment.models.cart.Item;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GetCartService getCartService;
    @MockBean
    CreateCartService createCartService;
    @MockBean
    UpdateCartService updateCartService;

    @Test
    @DisplayName("GET /cart-line-items")
    void list() throws Exception {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));
        Product newProduct = new Product(ProductName.of("데자부"), Price.of(13000));

        Item item = new Item(product, 2L);
        Item newItem = new Item(newProduct, 3L);

        List<ItemDto> lineItems = List.of(
                new ItemDto(item),
                new ItemDto(newItem));

        CartListItemDto cartListItemDto = new CartListItemDto(lineItems);

        given(getCartService.getCartLineItems())
                .willReturn(cartListItemDto);

        mockMvc.perform(get("/cart-line-items"))
                .andExpect(status().isOk()).andExpect(
                        MockMvcResultMatchers.content()
                                .string(containsString("39000")))
                .andExpect(MockMvcResultMatchers.content()
                        .string(containsString("랑데부")));
    }

    @Test
    @DisplayName("POST /cart-line-items")
    void addItem() throws Exception {
        String json = """
                {
                    "productId": "A1B2",
                    "quantity": 4
                }
                """;

        mockMvc.perform(post("/cart-line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        verify(createCartService).createCartLineItem(any(CartPostDto.class));
    }

    @Test
    @DisplayName("PATCH /cart-line-items")
    void changeItem() throws Exception {
        String json = """
                {
                    "quantity": 4
                }
                """;

        mockMvc.perform(patch("/cart-line-items/productId")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());

        verify(updateCartService).updateCartLineItem(any(String.class), any(CartUpdateDto.class));
    }
}