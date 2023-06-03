package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductService;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.dtos.ProductDtos;
import kr.megaptera.assignment.models.ProductId;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductService getProductService;

    @MockBean
    private CreateProductService createProductService;

    @Test
    void list() throws Exception {

        given(getProductService.getProductDtos()).willReturn(new ProductDtos(List.of(
            new ProductDto(ProductId.of("1").getValue(), "상품", 1000L)
        )));

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                containsString("{" +
                    "\"id\":\"1\"," +
                    "\"name\":\"상품\"," +
                    "\"price\":1000" +
                    "}")
            ));
    }

    @Test
    void createProdcut() throws Exception {
        String json = """
            {
                "name" : "상품",
                "price" : 1000
            }
            """;

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated());

        verify(createProductService).createProduct(any(CreateProductDto.class));
    }
}
