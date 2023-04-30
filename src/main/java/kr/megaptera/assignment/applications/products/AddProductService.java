package kr.megaptera.assignment.applications.products;

import jakarta.transaction.Transactional;
import kr.megaptera.assignment.domains.products.Product;
import kr.megaptera.assignment.domains.products.ProductId;
import kr.megaptera.assignment.infrastructures.ProductRepository;
import kr.megaptera.assignment.presentations.dtos.products.ProductCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AddProductService {
    @Autowired
    private ProductRepository productRepository;

    public void add(ProductCreateDto createDto){
        var product = new Product(new ProductId(), createDto.getName(), createDto.getPrice());
        productRepository.save(product);
    }
}
