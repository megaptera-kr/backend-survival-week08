package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.*;
import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private GetProductsService getProductsService;
    private CreateProductService createProductService;

    public ProductController(GetProductsService getProductsService, CreateProductService createProductService) {
        this.getProductsService = getProductsService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public Map<String, List<ProductDto>> list(){
        Map<String, List<ProductDto>> productMap = new HashMap<>();
        List<ProductDto> products = getProductsService.getProductDtos();
        productMap.put("products", products);
        return productMap;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody ProductCreateDto productCreateDto){
        createProductService.createProduct(productCreateDto);
    }
}
