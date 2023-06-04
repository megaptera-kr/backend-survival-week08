package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CreateProductService;
import kr.megaptera.assignment.application.GetProductsService;
import kr.megaptera.assignment.dtos.request.RqPostProductDto;
import kr.megaptera.assignment.dtos.response.RpGetProductsDto;
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

    private final GetProductsService getProductsService;
    private final CreateProductService createProductService;

    public ProductController(GetProductsService getProductsService,
                             CreateProductService createProductService) {
        this.getProductsService = getProductsService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public RpGetProductsDto getProductList() {
        return getProductsService.getProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postProduct(@RequestBody RqPostProductDto dto) {
        return createProductService.createProduct(dto);
    }
}
