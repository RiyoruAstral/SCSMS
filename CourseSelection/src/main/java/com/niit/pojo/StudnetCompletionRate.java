package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class StudnetCompletionRate {
    private int sno;
    private String sName;
    private String department;
    private int earnedProfessionalElectiveCredits;
    private int requiredProfessionalElectiveCredits;
    private int selectedProfessionalElectiveCourses;
    private int passedProfessionalElectiveCourses;

}
