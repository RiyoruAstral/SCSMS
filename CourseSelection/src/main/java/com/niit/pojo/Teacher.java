package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Teacher {
    private int tno;
    private String tName;
    private String tSex;
    private String tDuty;
    private int dno;
}
