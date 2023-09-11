package kr.megaptera.assignment.application;

import kr.megaptera.assignment.infrastructrue.ProductDtoFetcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GetProductListServiceTest {
    private ProductDtoFetcher productDtoFetcher;

    private GetProductListService getProductListService;

    @BeforeEach
    void setUp() {
        productDtoFetcher = mock(ProductDtoFetcher.class);

        getProductListService = new GetProductListService(productDtoFetcher);
    }

    @Test
    void getProductList() {
        getProductListService.getProductListDto();

        verify(productDtoFetcher).fetchProductListDto();
    }
}
