package kr.megaptera.assignment.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartId extends EntityId {

    public CartId(String id) {
        super(id);
    }

    public static CartId of(String id) {
        return new CartId(id);
    }

    public static CartId generate() {
        return new CartId(newTsid());
    }

}
