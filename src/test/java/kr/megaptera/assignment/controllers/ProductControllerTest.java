package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ProductService;
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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    @DisplayName("프로덕트 컨트롤러 products")
    void products() throws Exception {
        given(productService.getList()).willReturn(List.of(
                new ProductDto("001", "aaa", 100L),
                new ProductDto("002", "bbb", 1000L)
        ));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("aaa")))
                .andExpect(content().string(containsString("002")));
    }

    @Test
    @DisplayName("프로덕트 컨트롤러 create")
    void create() throws Exception {
        String json = """
                {"name" : "test",
                "price" : 1000}
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
    }


}