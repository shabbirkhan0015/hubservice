package com.hubService.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String streetAddress;
    private String appSuiteNumber;
    private String city;
    private String state;
    private String postalCode;
}