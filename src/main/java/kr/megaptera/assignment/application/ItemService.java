package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ItemDto;
import kr.megaptera.assignment.models.Item;
import kr.megaptera.assignment.models.ItemId;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDto> getItemsByProductId(String productId) {
        List<Item> items = itemRepository.findByProductId(ProductId.of(productId));
        return items.stream().map(item -> new ItemDto(item)).toList();
    }

    public ItemDto getItem(String id) {
        Item item = itemRepository.findById(ItemId.of(id)).orElseThrow();
        return new ItemDto(item);
    }

    public ItemDto addItem(ItemDto itemDto) {
        Item item = new Item(ProductId.of(itemDto.getProductId()), itemDto.getColor(),
                itemDto.getSize(), itemDto.getStock(), itemDto.getOriginalPrice(),
                itemDto.getOnSalePrice());

        item = itemRepository.save(item);
        return new ItemDto(item);
    }

    public ItemDto updateItem(String id, ItemDto itemDto) {
        Item item = itemRepository.findById(ItemId.of(id)).orElseThrow();
        item.update(itemDto.getStock(), itemDto.getOriginalPrice(), itemDto.getOnSalePrice());

        item = itemRepository.save(item);
        return new ItemDto(item);
    }

    public ItemDto removeItem(String id) {
        Item item = itemRepository.findById(ItemId.of(id)).orElseThrow();
        itemRepository.delete(item);
        return new ItemDto(item);
    }

}
