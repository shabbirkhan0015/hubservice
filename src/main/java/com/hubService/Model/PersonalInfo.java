package com.hubService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalInfo {
    private  String email;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private Integer postalcode;
    private Double monthlyHousePayment;

}
