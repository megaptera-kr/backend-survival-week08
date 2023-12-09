package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductService;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.GetProductsOutput;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.exceptions.CartLineItemNotFound;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import kr.megaptera.assignment.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
    private GetProductService getProductService;
    private CreateProductService createProductService;

    public ProductController(GetProductService getProductService, CreateProductService createProductService) {
        this.getProductService = getProductService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public GetProductsOutput get() {
        List<Product> products = getProductService.getProducts();
        return new GetProductsOutput(products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateProductDto createProductDto) {
        createProductService.create(createProductDto);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFound() {
        return "해당 상품을 찾을 수 없습니다.";
    }

    @ExceptionHandler(CartLineItemNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String CartLineItemNotFound() {
        return "장바구니에 해당 주문이 없습니다.";
    }
}
