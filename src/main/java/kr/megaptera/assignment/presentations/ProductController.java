package kr.megaptera.assignment.presentations;

import kr.megaptera.assignment.applications.products.AddProductService;
import kr.megaptera.assignment.applications.products.GetProductsService;
import kr.megaptera.assignment.presentations.dtos.products.ProductCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private GetProductsService getProductsService;
    @Autowired
    private AddProductService addProductService;

    @GetMapping
    public ResponseEntity findAll() {
        var productDtos = getProductsService.getAll();
        return ResponseEntity.ok(productDtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody ProductCreateDto reqBody){
        addProductService.add(reqBody);
    }
}
