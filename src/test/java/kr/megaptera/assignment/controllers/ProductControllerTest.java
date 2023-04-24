package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.application.product.*;
import kr.megaptera.assignment.exceptions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetProductDtosService getProductDtosService;

    @MockBean
    private GetProductDtoService getProductDtoService;

    @MockBean
    private CreateProductService createProductService;

    @MockBean
    private UpdateProductService updateProductService;

    @MockBean
    private DeleteProductService deleteProductService;

    @Test
    @DisplayName("GET 상품 목록")
    void list() throws Exception {
        given(getProductDtosService.getProductDTOs())
                .willReturn(
                        List.of(
                                new ProductDTO(
                                        "ID_001", "TOP_001", "jacket", 120_000, "cool"
                                ),
                                new ProductDTO(
                                        "ID_002", "BOTTOM_001", "jean", 85_000, "nice"
                                )
                        )
                );

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("jean")));
    }

    @Test
    @DisplayName("GET 상품 상세")
    void productDetail() throws Exception {
        String productId = "ID_001";

        given(getProductDtoService.getProductDTO(productId))
                .willReturn(
                        new ProductDTO(
                                productId,
                                "BOTTOM_01",
                                "jean",
                                85_000,
                                "Greatest jean")
                );

        given(getProductDtoService.getProductDTO("WrongID"))
                .willThrow(ProductNotFound.class);

        // 정상적인 요청
        mockMvc.perform(get("/products/" + productId))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("BOTTOM_01")));

        // 잘못된 요청
        mockMvc.perform(get("/products/" + "WrongID"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Product doesn't exist..")));
    }

    @Test
    @DisplayName("POST 상품 등록")
    void createProduct() throws Exception {
        String body = """
                {
                    "type": "top",
                    "name": "jacket",
                    "price": 75000,
                    "content": "nice jacket!!"
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("PATCH 상품 업데이트")
    void updateProduct() throws Exception {
        String productId = "ID_001";
        String body = """
                {
                    "name": "Cool jean",
                    "price": 50000,
                    "content": "changed Item"
                }
                """;

        mockMvc.perform(patch("/products/" + productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("DELETE 상품 삭제")
    void deleteProduct() throws Exception {
        String productId = "ID_001";

        mockMvc.perform(delete("/products/" + productId))
                .andExpect(status().isNoContent());

    }
}