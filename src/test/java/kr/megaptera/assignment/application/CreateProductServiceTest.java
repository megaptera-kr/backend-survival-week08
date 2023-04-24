package kr.megaptera.assignment.application;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import kr.megaptera.assignment.dtos.CreateProductRequest;
import kr.megaptera.assignment.models.Option;
import kr.megaptera.assignment.models.OptionGroup;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.repositories.OptionGroupRepository;
import kr.megaptera.assignment.repositories.OptionRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CreateProductServiceTest {

    @Autowired
    private CreateProductService createProductService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OptionGroupRepository optionGroupRepository;

    @Autowired
    private OptionRepository optionRepository;

    @DisplayName("Aggregate - 상품 생성시 옵션 그룹과 옵션이 모두 생성된다.")
    @Test
    void create() {
        // given
        Map<String, Double> optionMap1 = Map.of("Red & Black", 0D, "Black & White", 0D);
        Map<String, Double> optionMap2 = Map.of("정상가", 350_000D);
        Map<String, Double> optionMap3 = Map.of("250", 0D, "260", 0D, "270", 0D);

        List<Map<String, Map<String, Double>>> optionGroupInfos = List.of(
                Map.of("색상", optionMap1, "가격정보", optionMap2),
                Map.of("발사이즈", optionMap3));

        String productName = "에어 조던";
        CreateProductRequest request = new CreateProductRequest(productName, "나이키 운동화",
                optionGroupInfos);

        // when
        createProductService.createProduct(request);

        // then
        List<Product> productResult = productRepository.findAll();
        List<OptionGroup> optionGroupResult = optionGroupRepository.findAll();
        List<Option> optionResult = optionRepository.findAll();

        assertThat(productResult).hasSize(1);
        assertThat(optionGroupResult).hasSize(3);
        assertThat(optionResult).hasSize(6);

        assertThat(productResult.get(0).getName()).isEqualTo(productName);
    }
}
