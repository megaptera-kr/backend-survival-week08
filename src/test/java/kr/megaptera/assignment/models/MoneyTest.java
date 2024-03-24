package kr.megaptera.assignment.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void equals() {
        assertThat(new Money(100L)).isEqualTo(new Money(100L));
    }

    @Test
    void times() {
        assertThat(new Money(100L).times(2)).isEqualTo(new Money(200L));
    }
}
