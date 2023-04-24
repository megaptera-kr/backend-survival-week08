package kr.megaptera.assignment.Models.cart;

import jakarta.persistence.*;

import java.io.*;
import java.util.*;

@Embeddable
public class UserId implements Serializable {
    @Column(name = "user_id")
    private String value;

    public UserId() {
    }

    public UserId(String userId) {
        this.value = userId;
    }

    @Override
    public String toString() {
        return value;
    }

    public static UserId of(String userId) {
        return new UserId(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId1 = (UserId) o;
        return Objects.equals(value, userId1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String userId() {
        return value;
    }
}
