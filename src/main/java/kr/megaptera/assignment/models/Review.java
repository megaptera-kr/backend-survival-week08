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
    private String description;

    private LocalDateTime regDate;

    private String userId;

    @ManyToOne
    private Product product;

}
