package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

import javax.sound.sampled.*;
import java.util.*;

@Service
public class GetLineItemsService {
    private LineItemRepository lineItemRepository;

    public GetLineItemsService(LineItemRepository lineItemRepository) {
        this.lineItemRepository = lineItemRepository;
    }

    public List<LineItemDto> getLineItemDtos() {
        List<LineItem> lineItemList = lineItemRepository.findAll();
        return lineItemList.stream().map(LineItemDto::new).toList();
    }
}
