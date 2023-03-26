package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ProductService;
import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtos = productService.getProducts();
        return productDtos;
    }

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable String id) {
        ProductDto productDto = productService.getProduct(id);
        return productDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        ProductDto createdProductDto = productService.addProduct(productDto);
        return createdProductDto;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductDto updateProduct(@PathVariable String id, @RequestBody ProductDto productDto) {
        ProductDto updatedProductDto = productService.updateProduct(id, productDto);
        return updatedProductDto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProductDto removeProduct(@PathVariable String id) {
        ProductDto deletedProductDto = productService.removeProduct(id);
        return deletedProductDto;
    }

}
