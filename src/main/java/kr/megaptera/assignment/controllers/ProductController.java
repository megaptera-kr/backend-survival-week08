package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductsService;
import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.dtos.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    private final GetProductsService getProductsService;
    private final CreateProductService createProductService;

    public ProductController(GetProductsService getProductsService, CreateProductService createProductService) {
        this.getProductsService = getProductsService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public List<ProductDto> list() {
        List<ProductDto> productDtos = getProductsService.getProductDtos();

        return productDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductCreateDto productCreateDto) {
        createProductService.createProduct(productCreateDto);
    }
}
