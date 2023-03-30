package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Review {

    @EmbeddedId
    private ReviewId id;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String contents;

    private LocalDateTime regDateTime;

    private String userId;

    @ManyToOne
    private Product product;

    public Review(String contents, String userId, Product product) {
        this.id = ReviewId.generate();
        this.contents = contents;
        this.regDateTime = LocalDateTime.now();
        this.userId = userId;
        this.product = product;
    }

    public void update(String contents) {
        this.contents = contents;
    }

}
