package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.application.cart.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetProductsInCartService getProductsInCartService;

    @MockBean
    private AddProductInCartService addProductInCartService;

    @MockBean
    RemoveProductIncartService removeProductIncartService;

    @Test
    @DisplayName("GET 카트 목록 얻기")
    void getProductsInCart() throws Exception {
        String userId = "test";
        given(getProductsInCartService.getItemInCart(userId)).willReturn(
                List.of(new ProductDTO("ID_001", userId, "TOP_001", "jacket", 75000, 5, "nice jacket"),
                        new ProductDTO("ID_002", userId, "BOTTOM_001", "jean", 55000, 3, "great jean"))
        );

        mockMvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("jacket")));
    }

    @Test
    @DisplayName("POST 카트에 상품 넣기")
    void addProductInCart() throws Exception {
        String userId = "ID_001";
        String cartAddDTO = """
                {
                    "productId": "TOP_01",
                    "quantity": 5
                }
                """;
    }

    @Test
    @DisplayName("DELETE 카트 상품 삭제")
    void removeProductInCart() {

    }
}
