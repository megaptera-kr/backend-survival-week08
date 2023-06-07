package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateProductService;
import kr.megaptera.assignment.application.GetProductsService;
import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.dtos.ProductPostDto;
import kr.megaptera.assignment.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController {

    private final GetProductsService getProductsService;
    private final CreateProductService createProductService;

    public ProductController(GetProductsService getProductsService, CreateProductService createProductService) {
        this.getProductsService = getProductsService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public ProductListDto getProducts() {
        return new ProductListDto(getProductsService.getProducts());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductGetDto postProduct(
            @RequestBody ProductPostDto productPostDto
    ) {
        return createProductService.createProduct(productPostDto);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void productNotFound() {
    }

}
