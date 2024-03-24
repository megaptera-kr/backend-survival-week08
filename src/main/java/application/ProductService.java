package application;

import com.github.f4b6a3.tsid.TsidCreator;
import dtos.ProductDto;
import dtos.ProductInsertDto;
import jakarta.transaction.Transactional;
import models.Product;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getProductList() {
        Iterator<Product> productList = productRepository.findAll().iterator();
        List<ProductDto> productDtoList = new ArrayList<>();
        while (productList.hasNext()) {
            Product product = productList.next();
            productDtoList.add(new ProductDto(product));
        }
        return productDtoList;
    }

    @Transactional
    public void insertProduct(ProductInsertDto dto) {
        java.lang.String insertProductId = TsidCreator.getTsid().toString();
        Product insertProduct = new Product(insertProductId
                , new String(dto.getName())
                , dto.getPrice());
        productRepository.save(insertProduct);
    }
}
