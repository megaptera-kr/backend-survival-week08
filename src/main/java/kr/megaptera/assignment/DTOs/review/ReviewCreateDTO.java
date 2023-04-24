package kr.megaptera.assignment.DTOs.review;

public class ReviewCreateDTO {
    private String author;
    private String content;

    public ReviewCreateDTO() {
    }

    public ReviewCreateDTO(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
