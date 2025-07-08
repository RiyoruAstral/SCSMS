package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class TeacherCourse {
    private String tno;
    private String cno;
    private String cName;
    private String tName;
    private String dName;
    private String year;
    private int dayOfWeek;
    private int time;
    private int startWeek;
    private int endWeek;
    private int semester;
    private int credit;
    private String flag;
    private int remainPeople;
    private int totalPeople;

    public TeacherCourse(String tno,String tName, String cno, String cName, String dName, String year, int dayOfWeek, int time, int startWeek, int endWeek, int semester,int remainPeople,int totalPeople) {
        this.tno = tno;
        this.tName = tName;
        this.cno = cno;
        this.cName = cName;
        this.dName = dName;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.semester = semester;
        this.remainPeople = remainPeople;
        this.totalPeople = totalPeople;
    }


}
