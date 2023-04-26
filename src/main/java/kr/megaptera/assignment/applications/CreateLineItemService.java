package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CreateLineItemService {
    private LineItemRepository lineItemRepository;
    private ProductRepository productRepository;

    public CreateLineItemService(LineItemRepository lineItemRepository, ProductRepository productRepository) {
        this.lineItemRepository = lineItemRepository;
        this.productRepository = productRepository;
    }

    public void createlineItem(LineItemCreateDto lineItemCreateDto) {
        Product product =
                productRepository.findById(ProductId.of(lineItemCreateDto.getProductId())).orElseThrow();
        LineItem lineItem = new LineItem(product.getId(),product.getName(),lineItemCreateDto.getQuantity(),
                            product.getPrice() * lineItemCreateDto.getQuantity(),product.getPrice());
        lineItemRepository.save(lineItem);
    }
}
