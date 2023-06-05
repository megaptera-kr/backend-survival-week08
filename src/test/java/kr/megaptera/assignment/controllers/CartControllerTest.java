package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartService;
import kr.megaptera.assignment.applications.GetCartService;
import kr.megaptera.assignment.applications.UpdateCartService;
import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.CartItemDtos;
import kr.megaptera.assignment.dtos.CreateCartItemDto;
import kr.megaptera.assignment.dtos.UpdateCartItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetCartService getCartService;

    @MockBean
    private CreateCartService createCartService;

    @MockBean
    private UpdateCartService updateCartService;

    @Test
    void list() throws Exception {
        given(getCartService.getCartItemDtos()).willReturn(new CartItemDtos(List.of(new CartItemDto("1", "상품명", 1L, 3000L, 3000L))));

        mockMvc.perform(get("/cart-line-items"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("{" +
                    "\"id\":\"1\"," +
                    "\"productName\":\"상품명\"," +
                    "\"quantity\":1," +
                    "\"totalPrice\":3000," +
                    "\"unitPrice\":3000" +
                    "}")
            ));
    }

    @Test
    void createCartItem() throws Exception {
        String json = """
            {
                "productId" : 1,
                "quantity": 1
            }
            """;

        mockMvc.perform(post("/cart-line-items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated());

        verify(createCartService).createCartItem(any(CreateCartItemDto.class));
    }

    @Test
    void updateCartItem() throws Exception {
        String json = """
            {
                "quantity" : 1
            }
            """;

        mockMvc.perform(patch("/cart-line-items/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isNoContent());

        verify(updateCartService).updateCartItem(any(), any(UpdateCartItemDto.class));
    }
}
