package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.applications.CreateProductService;
import kr.megaptera.assignment.applications.GetProductListService;
import kr.megaptera.assignment.dtos.ProductCreateDto;
import kr.megaptera.assignment.dtos.ProductDetailListDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final GetProductListService getProductListService;
    private final CreateProductService createProductService;

    public ProductController(GetProductListService getProductListService, CreateProductService createProductService) {
        this.getProductListService = getProductListService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public ProductDetailListDto list() {
        return getProductListService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductCreateDto dto) {
        createProductService.create(dto);
    }
}
