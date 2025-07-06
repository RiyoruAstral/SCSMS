package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class Course {
    private int cno;
    private String cName;
    private int dno;
    private int credit;
    private int capacity;
    private String courseType;
}
