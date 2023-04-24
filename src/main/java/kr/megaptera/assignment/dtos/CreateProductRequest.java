package kr.megaptera.assignment.dtos;

import java.util.List;
import java.util.Map;

public class CreateProductRequest {
    private String name;
    private String description;

    private List<Map<String, Map<String, Double>>> optionGroups;

    public CreateProductRequest() {
    }

    public CreateProductRequest(String name, String description,
            List<Map<String, Map<String, Double>>> optionGroups) {
        this.name = name;
        this.description = description;
        this.optionGroups = optionGroups;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Map<String, Map<String, Double>>> getOptionGroups() {
        return optionGroups;
    }
}
