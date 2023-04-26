package kr.megaptera.assignment.applications;

import kr.megaptera.assignment.dtos.*;
import kr.megaptera.assignment.exceptions.*;
import kr.megaptera.assignment.models.*;
import kr.megaptera.assignment.repositories.*;
import org.springframework.stereotype.*;

@Service
public class UpdateLineItemsService {

    private LineItemRepository lineItemRepository;

    public UpdateLineItemsService(LineItemRepository lineItemRepository) {
        this.lineItemRepository = lineItemRepository;
    }

    public void updatelineItem(String id, LineItemUpdateDto lineItemUpdateDto) {
        LineItem lineItem = lineItemRepository.findById(id).orElseThrow(LineItemNotFound::new);
        lineItem.update(lineItemUpdateDto.getQuantity());
        lineItemRepository.save(lineItem);
    }
}
