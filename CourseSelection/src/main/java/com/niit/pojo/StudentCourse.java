package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class StudentCourse {
    private int sno;
    private String sName;
    private String className;
    private String cName;
    private String dayOfWeek;
    private int startTime;
    private int duration;
    private String academicYear;
    private int semester;
    private int startWeek;
    private int endWeek;
    private String weekRange;
    private String weekType;
    private String tName;
    private String classroom;
    private String courseType;
}
