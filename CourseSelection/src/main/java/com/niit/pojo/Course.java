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
    private String cno;
    private String cName;
    private int year;
    private int dayOfType;
    private int time;
    private int startWeek;
    private int endWeek;
    private int credit;
    private String type;
    private int semester;
    private int selectPeople;
    private int totalPeople;
    private int examTime;
    private int examWeek;


    public Course(String cName, int dayOfType, int time, int startWeek, int endWeek, int semester, int year) {
        this.cName = cName;
        this.dayOfType = dayOfType;
        this.time = time;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.semester = semester;
        this.year = year;
    }


}
