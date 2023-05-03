package kr.megaptera.assignment.presentations;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.megaptera.assignment.applications.products.AddProductService;
import kr.megaptera.assignment.applications.products.GetProductsService;
import kr.megaptera.assignment.presentations.dtos.products.ProductCreateDto;
import kr.megaptera.assignment.presentations.dtos.products.ProductDto;
import kr.megaptera.assignment.presentations.dtos.products.ProductListDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetProductsService getProductsService;
    @MockBean
    private AddProductService addProductService;

    @Test
    @DisplayName("GET /products")
    void list() throws Exception {
        var productDtos = List.of(new ProductDto("product-id", "product-name", 100_000L));

        given(getProductsService.getAll()).willReturn(new ProductListDto(productDtos));

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST /products")
    void add() throws Exception {

        var reqBody = new ProductCreateDto("product-name", 100_000L);
        ObjectMapper mapper = new ObjectMapper();
        var reqBodyContent = mapper.writeValueAsString(reqBody);

        var requestBuilder = MockMvcRequestBuilders.post("/products")
                .contentType("application/json")
                .content(reqBodyContent);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated());
    }
}