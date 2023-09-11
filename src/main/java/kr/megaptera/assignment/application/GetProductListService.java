package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.infrastructrue.ProductDtoFetcher;
import org.springframework.stereotype.Service;

@Service
public class GetProductListService {
    private final ProductDtoFetcher productDtoFetcher;

    public GetProductListService(ProductDtoFetcher productDtoFetcher) {
        this.productDtoFetcher = productDtoFetcher;
    }

    public ProductListDto getProductListDto() {
        return productDtoFetcher.fetchProductListDto();
    }
}
