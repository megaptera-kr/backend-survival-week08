package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CartService;
import kr.megaptera.assignment.dtos.CartDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartService cartService;

    @Test
    @DisplayName("카트컨트롤러 getList")
    void getList() throws Exception {
        given(cartService.getCartLists()).willReturn(List.of(
                new CartDto("001", "test", 2L, 100L),
                new CartDto("002", "aaa", 5L, 10L),
                new CartDto("003", "bbb", 10L, 150L)
        ));

        mockMvc.perform(get("/cart-line-items"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("aaa")))
                .andExpect(content().string(containsString("test")))
                .andExpect(content().string(containsString("bbb")));
    }

    @Test
    @DisplayName("카트컨트롤러 create")
    void create() throws Exception {
        String json = """
                {"productId" : "0101",
                "quantity" : 100}
                """;

        mockMvc.perform(post("/cart-line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("카트컨트롤러 update")
    void update() throws Exception {
        String json = """
                {"quantity" : 10}
                """;

        String id = "0101";

        mockMvc.perform(patch("/cart-line-items/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());
    }


}