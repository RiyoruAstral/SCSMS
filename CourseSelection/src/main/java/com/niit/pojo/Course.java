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
}
