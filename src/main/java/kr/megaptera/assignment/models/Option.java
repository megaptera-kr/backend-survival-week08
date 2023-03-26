package kr.megaptera.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_groups_id")
    private OptionGroup optionGroup;

    @Column(length = 100)
    private String value;

    @Embedded
    private Price price;

    protected Option() {
    }

    public Option(OptionGroup optionGroup, String value, Price price) {
        this.optionGroup = optionGroup;
        this.value = value;
        this.price = price;
    }

    public Option(Long id, OptionGroup optionGroup, String value, Price price) {
        this.id = id;
        this.optionGroup = optionGroup;
        this.value = value;
        this.price = price;
    }

    public static Option create(OptionGroup optionGroup, String optionName, Double price) {
        return new Option(optionGroup, optionName, Price.won(price));
    }


    public Long getId() {
        return id;
    }

    public OptionGroup getOptionGroup() {
        return optionGroup;
    }

    public String getValue() {
        return value;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Option option = (Option) o;
        return id.equals(option.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
