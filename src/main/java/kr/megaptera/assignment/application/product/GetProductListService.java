package kr.megaptera.assignment.application.product;

import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.infrastructure.ProductDtoFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GetProductListService {
    private final ProductDtoFetcher productDtoFetcher;

    public GetProductListService(ProductDtoFetcher productDtoFetcher) {
        this.productDtoFetcher = productDtoFetcher;
    }

    public ProductListDto getProductListDto() {
        return productDtoFetcher.fetchProductListDto();
    }
}