package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateProductService;
import kr.megaptera.assignment.application.GetProductsService;
import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.models.products.Price;
import kr.megaptera.assignment.models.products.Product;
import kr.megaptera.assignment.models.products.ProductName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GetProductsService getProductsService;
    @MockBean
    CreateProductService createProductService;

    @Test
    @DisplayName("GET /products")
    void list() throws Exception {
        Product product = new Product(ProductName.of("랑데부"), Price.of(15000));
        Product newProduct = new Product(ProductName.of("데자부"), Price.of(13000));

        given(getProductsService.getProducts())
                .willReturn(List.of(
                        new ProductGetDto(
                                product.id().getId(),
                                product.name().getName(),
                                product.price().getValue()),
                        new ProductGetDto(
                                newProduct.id().getId(),
                                newProduct.name().getName(),
                                newProduct.price().getValue())));

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(containsString("데자부")));
    }

    @Test
    @DisplayName("POST /products")
    void addProduct() throws Exception {
        String json = """
                {
                    "name": "랑데부",
                    "price": 15000
                }
                """;

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());

        verify(createProductService).createProduct(any(ProductCreateDto.class));
    }

}