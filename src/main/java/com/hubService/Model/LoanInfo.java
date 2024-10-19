package com.hubService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanInfo {
    private String LoanType;
    private Double LoanAmount;
}
