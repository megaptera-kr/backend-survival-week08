package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.DTOs.product.*;
import kr.megaptera.assignment.application.product.*;
import kr.megaptera.assignment.exceptions.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
    private final GetProductDtosService getProductDtosService;

    private final GetProductDtoService getProductDtoService;

    private final CreateProductService createProductService;

    private final UpdateProductService updateProductService;

    private final DeleteProductService deleteProductService;

    public ProductController(GetProductDtosService getProductDtosService,
                             GetProductDtoService getProductDtoService,
                             CreateProductService createProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService) {
        this.getProductDtosService = getProductDtosService;
        this.getProductDtoService = getProductDtoService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
    }

    @GetMapping
    public List<ProductDTO> list() {
        List<ProductDTO> productDTOs = getProductDtosService.getProductDTOs();

        return productDTOs;
    }

    @GetMapping("/{id}")
    public ProductDTO detail(
            @PathVariable String id
    ) {
        ProductDTO productDTO = getProductDtoService.getProductDTO(id);
        return productDTO;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(
            @RequestBody ProductCreateDTO productCreateDTO
    ) {
        ProductDTO productDTO = createProductService.create(productCreateDTO);

        return productDTO;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
            @PathVariable String id,
            @RequestBody ProductUpdateDTO productUpdateDTO
    ) {
        updateProductService.update(id, productUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id
    ) {
        deleteProductService.delete(id);
    }

    @ExceptionHandler(ProductNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFound() {
        return "Product doesn't exist..";
    }
}
