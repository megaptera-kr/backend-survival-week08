package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductService;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.ProductDtos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private final GetProductService getProductService;
    private final CreateProductService createProductService;

    public ProductController(GetProductService getProductService,
                             CreateProductService createProductService) {
        this.getProductService = getProductService;
        this.createProductService = createProductService;
    }

    @GetMapping
    private ProductDtos list() {
        return getProductService.getProductDtos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void create(@RequestBody CreateProductDto createProductDto) {
        createProductService.createProduct(createProductDto);
    }
}
