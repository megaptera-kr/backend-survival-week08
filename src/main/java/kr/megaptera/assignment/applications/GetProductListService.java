package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.ProductDetailDto;
import kr.megaptera.assignment.dtos.ProductDetailListDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductListService {
    private final ProductRepository productRepository;

    public GetProductListService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDetailListDto list() {
        return listResult(
                productRepository.findAll().stream()
                        .map(this::productDetailDto)
                        .toList());
    }

    public ProductDetailDto productDetailDto(Product product) {
        return ProductDetailDto.of(
                product.getProductId().toString(),
                product.getProductName().getValue(),
                product.getPrice().getValue()
        );
    }

    public ProductDetailListDto listResult(List<ProductDetailDto> detailDtoList) {
        return ProductDetailListDto.of(detailDtoList);
    }
}
