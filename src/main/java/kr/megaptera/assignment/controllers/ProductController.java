package kr.megaptera.assignment.controllers;


import kr.megaptera.assignment.application.product.CreateProductService;
import kr.megaptera.assignment.application.product.GetProductListService;
import kr.megaptera.assignment.dtos.CreateProductDto;
import kr.megaptera.assignment.dtos.ProductListDto;
import kr.megaptera.assignment.models.Money;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductController {
    private final GetProductListService getProductListService;
    private final CreateProductService createProductService;

    public ProductController(GetProductListService getProductListService,
                             CreateProductService createProductService) {
        this.getProductListService = getProductListService;
        this.createProductService = createProductService;
    }

    @GetMapping
    public ProductListDto list() {
        return getProductListService.getProductListDto();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateProductDto dto) {
        String name = dto.name().strip();
        Money price = new Money(dto.price());

        createProductService.createProduct(name, price);
    }
}
