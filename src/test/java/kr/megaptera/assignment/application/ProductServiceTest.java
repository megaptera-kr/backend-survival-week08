package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.models.ProductName;
import kr.megaptera.assignment.models.ProductPrice;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    @DisplayName("프로덕트 서비스 list")
    void list() {
        ProductId productId = new ProductId("100");
        ProductName productName = new ProductName("test");
        ProductPrice productPrice = new ProductPrice(100L);
        given(productRepository.findAll()).willReturn(List.of(
                new Product(productId, productName, productPrice),
                new Product(new ProductId("102"), productName, productPrice)
        ));

        List<ProductDto> dtoList = productService.getList();

        assertThat(dtoList).hasSize(2);
    }

    @Test
    @DisplayName("프로덕트 서비스 create")
    void create() {
        ProductDto productDto = new ProductDto("100", "aaa", 100L);
        Product product = new Product(ProductId.of(productDto.getId()), ProductName.of(productDto.getName()), ProductPrice.of(productDto.getPrice()));

        productRepository.save(product);

        verify(productRepository).save(any(Product.class));
    }
}