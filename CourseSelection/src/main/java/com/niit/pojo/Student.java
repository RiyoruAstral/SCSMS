package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Student {
    private int sno;
    private String sName;
    private String sSex;
    private String sAge;
    private int dno;
}
