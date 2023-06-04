package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ProductService;
import kr.megaptera.assignment.dtos.ProductGetDto;
import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.dtos.ProductPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductListDto getProducts() {
        return new ProductListDto(productService.getProducts());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductGetDto postProduct(
            @RequestBody ProductPostDto productPostDto
    ) {
        return productService.createProduct(productPostDto);
    }

}
