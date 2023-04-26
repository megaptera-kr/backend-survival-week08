package kr.megaptera.assignment.dtos;

public class LineItemUpdateDto {
    private Long quantity;

    public LineItemUpdateDto() {
    }

    public LineItemUpdateDto(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }
}
