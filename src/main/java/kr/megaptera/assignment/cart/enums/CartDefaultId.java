package kr.megaptera.assignment.cart.enum;
public enum CartDefaultID {
    DEFAULT_ID("default_id_value"); // 기본 ID 값

    private final String value;

    DefaultId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}