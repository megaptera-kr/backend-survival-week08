package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.*;
import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.application.cart.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@WebMvcTest(CartController.class)
public class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetProductsInCartService getProductsInCartService;

    @MockBean
    private AddProductInCartService addProductInCartService;

    @MockBean
    private RemoveProductIncartService removeProductIncartService;

    @Test
    @DisplayName("GET 카트 목록 얻기")
    void getProductsInCart() throws Exception {
        String userId = "test";
        given(getProductsInCartService.getItemInCart(userId)).willReturn(
                List.of(new ProductDTO("ID_001", userId, "TOP_001", "jacket", 75000, 5, "nice jacket"),
                        new ProductDTO("ID_002", userId, "BOTTOM_001", "jean", 55000, 3, "great jean"))
        );

        assertThat(getProductsInCartService.getItemInCart(userId)).hasSize(2);
    }

    @Test
    @DisplayName("POST 카트에 상품 넣기")
    void addProductInCart() throws Exception {
        String userId = "test";
        CartAddDTO cartAddDTO = new CartAddDTO("jean", 4);

        given(getProductsInCartService.getItemInCart(userId)).willReturn(
                List.of(new ProductDTO("ID_001", userId, "TOP_001", "jacket", 75000, 5, "nice jacket"),
                        new ProductDTO("jean", userId, "BOTTOM_001", "blue_jean", 55000, 3, "great jean"))
        );

        assertThat(getProductsInCartService.getItemInCart(userId)).hasSize(2);

        addProductInCartService.addProduct(userId, cartAddDTO);

        assertThat(getProductsInCartService.getItemInCart(userId).get(1).getProductId()).isEqualTo("jean");
        assertThat(getProductsInCartService.getItemInCart(userId).get(1).getQuantity()).isEqualTo(4);
    }

    @Test
    @DisplayName("DELETE 카트 상품 삭제")
    void removeProductInCart() {

    }
}
