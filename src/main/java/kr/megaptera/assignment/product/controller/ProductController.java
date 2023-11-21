package kr.megaptera.assignment.product.controller;

import kr.megaptera.assignment.product.dto.CreateProductRequest;
import kr.megaptera.assignment.product.dto.ProductListResponse;
import kr.megaptera.assignment.product.dto.ProductResponse;
import kr.megaptera.assignment.product.domain.Money;
import kr.megaptera.assignment.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListResponse list() {
        List<ProductResponse> products = productService.listProduct();
        return new ProductListResponse(products);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateProductRequest request) {
        productService.createProduct(request);
    }
}
