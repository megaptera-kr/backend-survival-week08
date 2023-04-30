package kr.megaptera.assignment.applications.products;

import kr.megaptera.assignment.infrastructures.ProductRepository;
import kr.megaptera.assignment.presentations.dtos.products.ProductDto;
import kr.megaptera.assignment.presentations.dtos.products.ProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService {
    @Autowired
    private ProductRepository productRepository;

    public ProductListDto getAll() {
        var products = productRepository.findAll();
        // TODO : (dh) DTO 역할에 충실하게 하기위해서, 직접적인 연관관계를 의도적으로 사용하지 않았다.
        var dtos = products.stream().map(
                row -> new ProductDto(
                        row.getProductId().toString(),
                        row.getName(),
                        row.getPrice()))
                .toList();

        return new ProductListDto(dtos);
    }
}
