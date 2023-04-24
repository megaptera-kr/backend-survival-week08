package kr.megaptera.assignment.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.megaptera.assignment.models.Option;
import kr.megaptera.assignment.models.OptionGroup;
import kr.megaptera.assignment.models.Product;

public class ProductResponse {

    private Long id;
    private String name;
    private String description;

    private List<Map<String, Map<String, BigDecimal>>> optionInfos = new ArrayList<>();

    public ProductResponse(Long id, String name, String description,
            List<Map<String, Map<String, BigDecimal>>> optionInfos) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.optionInfos = optionInfos;
    }

    public ProductResponse(Product product) {
        List<OptionGroup> optionGroups = product.getOptionGroups();

        for (OptionGroup optionGroup : optionGroups) {
            List<Option> options = optionGroup.getOptions();

            Map<String, BigDecimal> optionInfo = new HashMap<>();
            for (Option option : options) {
                optionInfo.put(option.getValue(), option.getPrice().getValue());
            }

            Map<String, Map<String, BigDecimal>> optionGroupMap = new HashMap<>();

            optionGroupMap.put(optionGroup.getName(), optionInfo);
            this.optionInfos.add(optionGroupMap);
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Map<String, Map<String, BigDecimal>>> getOptionInfos() {
        return optionInfos;
    }
}
