package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.CreateCartLineItemsInputDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCartLineItemsService {
    private ProductRepository productRepository;

    public CreateCartLineItemsService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Transactional
    public void createCartLineItems(CreateCartLineItemsInputDto createCartLineItemsInputDto) {
        Product product = productRepository.findById(Long.valueOf(createCartLineItemsInputDto.getProductId())).get();
        if (product == null) {
            throw new ProductNotFound();
        }
        // cartLineItemRepository.save(new CartLineItem(createCartLineItemsInput, product));
        product.updateCartLineItemQuantity(createCartLineItemsInputDto.getQuantity());
    }
}
