package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Product;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String id;

    private String name;

    private String description;

    private String brand;

    private String category;

    private String subCategory;

    private LocalDateTime regDateTime;

    public ProductDto(Product product) {
        this(product.getId().toString(), product.getName(), product.getDescription(),
                product.getBrand(), product.getCategory(), product.getSubCategory(), product.getRegDateTime());
    }

}
