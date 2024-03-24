package controller;

import application.ProductService;
import dtos.ProductDto;
import dtos.ProductInsertDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getProductList() {
        return productService.getProductList();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void insertProduct(@RequestBody ProductInsertDto dto) {
        System.out.println("TEST");
        productService.insertProduct(dto);
    }
}
