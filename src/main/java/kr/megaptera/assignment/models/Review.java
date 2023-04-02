package kr.megaptera.assignment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Review {

    @EmbeddedId
    private ReviewId id;

    @ManyToOne
    private Product product;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String contents;

    private LocalDateTime regDateTime;

    @ColumnDefault("1")
    private String accountId;

    public Review(String contents, String accountId, Product product) {
        this.id = ReviewId.generate();
        this.contents = contents;
        this.regDateTime = LocalDateTime.now();
        this.accountId = accountId;
        this.product = product;
    }

    public void update(String contents) {
        this.contents = contents;
    }

}
