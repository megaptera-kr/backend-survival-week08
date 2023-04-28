package kr.megaptera.assignment.applications;

import com.sun.jdi.*;
import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.exceptions.*;
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
        validateQuantity(lineItemCreateDto);
        Product product =
                productRepository.findById(ProductId.of(lineItemCreateDto.getProductId())).orElseThrow(ProductNotFound::new);
        LineItem lineItem = new LineItem(product.getId(),product.getName(),lineItemCreateDto.getQuantity(),
                            product.getPrice() * lineItemCreateDto.getQuantity(),product.getPrice());
        lineItemRepository.save(lineItem);
    }

    private static void validateQuantity(LineItemCreateDto lineItemCreateDto) {
        if(lineItemCreateDto.getQuantity()<1 || lineItemCreateDto.getQuantity()>9999)
            throw new InvalidNumberException();
    }
}
