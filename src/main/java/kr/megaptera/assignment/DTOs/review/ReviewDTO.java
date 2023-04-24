package kr.megaptera.assignment.DTOs.review;

import kr.megaptera.assignment.Models.review.*;

public class ReviewDTO {
    private String id;
    private String productId;
    private String author;
    private String content;

    public ReviewDTO() {
    }

    public ReviewDTO(String id, String productId, String author, String content) {
        this.id = id;
        this.productId = productId;
        this.author = author;
        this.content = content;
    }

    public ReviewDTO(Review review) {
        this(
                review.id(),
                review.productId().toString(),
                review.author(),
                review.content().toString());
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
