package kr.megaptera.assignment.DTOs.review;

public class ReviewUpdateDTO {
    private String content;

    public ReviewUpdateDTO() {
    }

    public ReviewUpdateDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
