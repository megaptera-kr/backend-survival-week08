package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.products.CreateProductService;
import kr.megaptera.assignment.application.products.GetListProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateProductService createProductService;
    @MockBean
    private GetListProductService getListProductService;

    @Test
    @DisplayName("POST /products")
    void testPostproducts() throws Exception {
        String mockName = "name";
        Long mockPrice = 0L;

        String createProductRequestData = """
                {
                    "name": "%s",
                    "price": "%d"
                }
                """.formatted(mockName, mockPrice);

        RequestBuilder requestBuilder = post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createProductRequestData);

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("GET /products")
    void testGetproducts() throws Exception {
        RequestBuilder requestBuilder = get("/products");

        this.mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}