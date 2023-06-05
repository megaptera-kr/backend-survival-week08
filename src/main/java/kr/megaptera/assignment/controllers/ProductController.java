package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ProductService;
import kr.megaptera.assignment.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<ProductDto>> getList() {
        Map<String, List<ProductDto>> products = new HashMap<String, List<ProductDto>>();
        products.put("products", productService.getList());
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(
            @RequestBody ProductDto productDto
    ) {
        productService.create(productDto);
    }
}
