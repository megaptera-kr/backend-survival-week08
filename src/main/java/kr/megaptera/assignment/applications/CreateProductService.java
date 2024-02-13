package kr.megaptera.assignment.applications;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.models.Price;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductName;
import kr.megaptera.assignment.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void create(ProductCreateDto dto) {
        productRepository.save(product(dto));
    }

    public Product product(ProductCreateDto dto) {
        return Product.create(
                ProductName.of(dto.getName()),
                Price.of(dto.getPrice())
        );
    }
}
