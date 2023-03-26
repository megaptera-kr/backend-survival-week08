package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String zipCode;

    private String district;

    private String detail;

}
