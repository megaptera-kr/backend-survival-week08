package kr.megaptera.assignment.Models;

import jakarta.persistence.*;

import java.util.*;

@Embeddable
public class MultilineText {
    @Column(name = "content", columnDefinition = "TEXT")
    private String contents;

    public MultilineText() {
    }

    public MultilineText(String contents) {
        this.contents = contents;
    }

    public static MultilineText of(String contents) {
        return new MultilineText(contents);
    }

    @Override
    public String toString() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultilineText that = (MultilineText) o;
        return Objects.equals(contents, that.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents);
    }
}
