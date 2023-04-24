package kr.megaptera.assignment.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "option_groups")
public class OptionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    private Product product;

    @Column(length = 100)
    private String name;

    @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    protected OptionGroup() {
    }

    public OptionGroup(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public OptionGroup(Long id, Product product, String name, List<Option> options) {
        this.id = id;
        this.product = product;
        this.name = name;
        this.options = options;
    }

    public static OptionGroup create(Product product, String groupName, Map<String, Double> optionMap) {
        OptionGroup optionGroup = new OptionGroup(product, groupName);
        List<Option> optionList = optionGroup.getOptions();

        for (String optionName : optionMap.keySet()) {
            optionList.add(Option.create(optionGroup, optionName, optionMap.get(optionName)));
        }

        return optionGroup;
    }


    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }

    public List<Option> getOptions() {
        return options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OptionGroup that = (OptionGroup) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
