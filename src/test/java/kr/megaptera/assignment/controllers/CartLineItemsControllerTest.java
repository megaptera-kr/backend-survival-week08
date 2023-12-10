package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateCartLineItemsService;
import kr.megaptera.assignment.applications.GetCartLineItemsService;
import kr.megaptera.assignment.applications.UpdateCartLineItemsService;
import kr.megaptera.assignment.dtos.CreateCartLineItemsInputDto;
import kr.megaptera.assignment.dtos.UpdateCartLineItemsInputDto;
import kr.megaptera.assignment.models.CartLineItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.CartLineItemRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartLineItemsController.class)
class CartLineItemsControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    GetCartLineItemsService getCartLineItemsService;

    @MockBean
    CreateCartLineItemsService createCartLineItemsService;

    @MockBean
    UpdateCartLineItemsService updateCartLineItemsService;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    private CartLineItemRepository cartLineItemRepository;

    private Product PRODUCT;
    private Long PRODUCT_ID;


    @BeforeEach
    void setUp() {
        PRODUCT = new Product("productName", 1000L);
        PRODUCT_ID = 1L;
    }

    @Test
    @DisplayName("장바구니 조회 - GET /cart-line-items")
    void get() throws Exception {
        given(getCartLineItemsService.getLineItems())
                .willReturn(List.of(new CartLineItem(PRODUCT, PRODUCT_ID)));

        mockMvc.perform(MockMvcRequestBuilders.get("/cart-line-items"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("productName")));
    }

    @Test
    @DisplayName("장바구니 생성 - POST /cart-line-items")
    void create() throws Exception {
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.ofNullable(PRODUCT));
        String json = """
                {
                  "productId": "1",
                  "quantity": 100
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/cart-line-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
        verify(createCartLineItemsService).createCartLineItems(
                any(CreateCartLineItemsInputDto.class)
        );
    }

    @Test
    @DisplayName("장바구니 상품 수량 변경 - PATCH /cart-line-items/{id}")
    void update() throws Exception {
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.ofNullable(PRODUCT));
        CartLineItem cartLineItem = new CartLineItem(PRODUCT, 1L);
        given(cartLineItemRepository.findById(PRODUCT_ID)).willReturn(Optional.of(cartLineItem));
        String json = """
                {
                  "quantity": 100
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.patch("/cart-line-items" + "/" + PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNoContent());

        verify(updateCartLineItemsService)
                .updateQuantity(any(String.class), any(UpdateCartLineItemsInputDto.class)
                );
    }
}