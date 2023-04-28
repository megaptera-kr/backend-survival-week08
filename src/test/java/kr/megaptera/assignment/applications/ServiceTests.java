package kr.megaptera.assignment.applications;


import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ServiceTests {

    private GetProductsService getProductsService;
    private CreateProductService createProductService;
    private GetLineItemsService getLineItemsService;
    private CreateLineItemService createLineItemService;
    private UpdateLineItemsService updateLineItemsService;

    private ProductRepository productRepository;
    private LineItemRepository lineItemRepository;

    @BeforeEach
    void 셋업(){
        productRepository = mock(ProductRepository.class);
        lineItemRepository = mock(LineItemRepository.class);

        getProductsService = new GetProductsService(productRepository);
        createProductService = new CreateProductService(productRepository);
        getLineItemsService = new GetLineItemsService(lineItemRepository);
        createLineItemService = new CreateLineItemService(lineItemRepository,productRepository);
        updateLineItemsService = new UpdateLineItemsService(lineItemRepository);

    }
    @Test
    void 상품만들기() {
        ProductCreateDto productCreateDto = new ProductCreateDto("아이패드",100000L);
        createProductService.createProduct(productCreateDto);
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void 상품불러오기(){
        given(productRepository.findAll())
                .willReturn(List.of(new Product(new ProductId("ID"),"name",1000L)));
        List<ProductDto> productDto = getProductsService.getProductDtos();
        assertThat(productDto).hasSize(1);
        verify(productRepository).findAll();
    }

    @Test
    void 품목확인(){
        given(lineItemRepository.findAll())
                .willReturn(List.of(new LineItem("ID","name",100L,200L,300L)));
        List<LineItemDto> lineItemDtos = getLineItemsService.getLineItemDtos();
        assertThat(lineItemDtos).hasSize(1);
        verify(lineItemRepository).findAll();
    }

    @Test
    void 품목생성(){
        Product product = new Product(new ProductId("1"), "name", 100L);
        given(productRepository.findById(new ProductId("1"))).willReturn(Optional.of(product));
        LineItemCreateDto lineItemCreateDto = new LineItemCreateDto("1",2L);
        createLineItemService.createlineItem(lineItemCreateDto);
        verify(lineItemRepository).save(any(LineItem.class));
    }

    @Test
    void 없는품목생성(){
        given(productRepository.findById(new ProductId("1")))
                .willReturn(Optional.empty());
        LineItemCreateDto lineItemCreateDto = new LineItemCreateDto("2",2L);
        assertThrows(ProductNotFound.class, () -> createLineItemService.createlineItem(lineItemCreateDto));

    }

    @Test
    void 품목업데이트(){

    }

}
