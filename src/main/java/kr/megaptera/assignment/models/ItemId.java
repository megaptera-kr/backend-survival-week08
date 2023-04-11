package kr.megaptera.assignment.models;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemId extends EntityId {

    public ItemId(String id) {
        super(id);
    }

    public static ItemId of(String id) {
        return new ItemId(id);
    }

    public static ItemId generate() {
        return new ItemId(newTsid());
    }

}
