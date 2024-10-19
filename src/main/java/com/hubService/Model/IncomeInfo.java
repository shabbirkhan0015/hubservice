package com.hubService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeInfo {

    private String employmentStatus;
    private String selectedIndustry;
    private Double grossAnnualIncome;
    private String jobTitle;
    private String employerName;

}
