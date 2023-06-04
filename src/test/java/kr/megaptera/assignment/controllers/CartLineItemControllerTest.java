package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartItemService;
import kr.megaptera.assignment.applications.GetCartItemsService;
import kr.megaptera.assignment.applications.UpdateCartItemService;
import kr.megaptera.assignment.dtos.CartItemCreateDto;
import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.CartItemUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartLineItemController.class)
public class CartLineItemControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CreateCartItemService createCartItemService;

    @MockBean
    private GetCartItemsService getCartItemsService;

    @MockBean
    private UpdateCartItemService updateCartItemService;

    @Test
    @DisplayName("POST /cart-line-items")
    void create() throws Exception {
        String json = """
                {
                  "productId": "A-1",
                  "quantity": 2
                }
                """;


        mockMvc.perform(post("/cart-line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isCreated());

        verify(createCartItemService).createCartItem(any(CartItemCreateDto.class));

    }

    @Test
    @DisplayName("GET /cart-line-items")
    void list() throws Exception {
        given(getCartItemsService.getCartItemDtos()).willReturn(List.of(
                new CartItemDto("A-1", "A", 3, 6000L, 2000L),
                new CartItemDto("A-2", "B", 4, 4000L, 1000L)
        ));

        mockMvc.perform(get("/cart-line-items"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("A-1")
                ));
    }

    @Test
    @DisplayName("PATCH /cart-line-items/{id}")
    void update() throws Exception {
        String id = "1";

        String json = """
                {
                  "quantity": 3
                }
                """;

        mockMvc.perform(patch("/cart-line-items/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isNoContent());

        verify(updateCartItemService)
                .updateCartItemProdudctQuantity(eq(id), any(CartItemUpdateDto.class));
    }
}
