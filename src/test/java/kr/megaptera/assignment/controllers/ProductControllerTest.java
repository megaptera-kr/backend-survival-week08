package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductsService;
import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.dtos.ProductDto;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GetProductsService getProductsService;

    @MockBean
    private CreateProductService createProductService;

    @Test
    @DisplayName("GET /products")
    void list() throws Exception {
        given(getProductsService.getProductDtos()).willReturn(
                List.of(
                        new ProductDto("1", "A", Long.valueOf(2000)),
                        new ProductDto("2", "B", Long.valueOf(3000))
                )
        );

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("A")
                ));

    }

    @Test
    @DisplayName("POST /products")
    void create() throws Exception {
        String json = """
                {
                  "name": "A-1",
                  "price": 2000
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isCreated());

        verify(createProductService).createProduct(any(ProductCreateDto.class));
    }
}
