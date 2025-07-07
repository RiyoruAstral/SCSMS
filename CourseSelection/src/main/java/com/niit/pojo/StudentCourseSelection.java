package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class StudentCourseSelection {
    private int cno;
    private String cName;
    private int credit;
    private String teacher;
    private String startTime;
    private String location;
    private int remainingStudent;
    private String flag;
    private String prerequisite;
}
