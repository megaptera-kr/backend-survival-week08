package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.products.CreateProductService;
import kr.megaptera.assignment.application.products.GetListProductService;
import kr.megaptera.assignment.dtos.products.CreateProductDto;
import kr.megaptera.assignment.dtos.products.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final CreateProductService createProductService;
    private final GetListProductService getListProductService;

    public ProductController(CreateProductService createProductService, GetListProductService getListProductService) {
        this.createProductService = createProductService;
        this.getListProductService = getListProductService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestBody CreateProductDto createProductDto) {
        this.createProductService.createProduct(createProductDto);
    }

    @GetMapping("")
    public List<ProductDto> getProduct() {
        return this.getListProductService.getListProduct();
    }
}
