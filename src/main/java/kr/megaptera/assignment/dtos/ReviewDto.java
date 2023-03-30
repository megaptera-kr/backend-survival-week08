package kr.megaptera.assignment.dtos;

import jakarta.persistence.*;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.Review;
import kr.megaptera.assignment.models.ReviewId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private String id;

    private String contents;

    private LocalDateTime regDateTime;

    private String userId;

    @ManyToOne
    private Product product;

    public ReviewDto(Review review) {
        this(review.getId().toString(), review.getContents(), review.getRegDateTime(),
                review.getUserId(), review.getProduct());
    }

}
