package kr.megaptera.assignment.Models.review;

import com.github.f4b6a3.tsid.*;
import jakarta.persistence.*;
import kr.megaptera.assignment.DTOs.review.*;
import kr.megaptera.assignment.Models.*;
import kr.megaptera.assignment.Models.product.*;

import java.util.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @Column(name = "id")
    private String id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "product_id"))
    private ProductId productId;
    @Column(name = "author")
    private String author;
    @Embedded
    private MultilineText content;

    public Review() {
    }

    public Review(String id, ProductId productId, String author, MultilineText content) {
        this.id = id;
        this.productId = productId;
        this.author = author;
        this.content = content;
    }

    public Review(ProductId productId, String author, MultilineText content) {
        this.id = TsidCreator.getTsid().toString();
        this.productId = productId;
        this.author = author;
        this.content = content;
    }

    public String id() {
        return id;
    }

    public ProductId productId() {
        return productId;
    }

    public String author() {
        return author;
    }

    public MultilineText content() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(productId, review.productId) && Objects.equals(author, review.author) && Objects.equals(content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, author, content);
    }

    public void update(ReviewUpdateDTO reviewUpdateDTO) {
        this.content = MultilineText.of(reviewUpdateDTO.getContent());
    }
}
