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
    private String sno;
    private String sName;
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
    private int grade;

    public StudentCourse(String sName, String cno, String cName, String tName, String dName, String year, int dayOfWeek, int time, int startWeek, int endWeek, int semester,int credit,int grade) {
        this.sName = sName;
        this.cno = cno;
        this.cName = cName;
        this.tName = tName;
        this.dName = dName;
        this.year = year;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.semester = semester;
        this.credit = credit;
        this.grade = grade;
    }

    public StudentCourse(String cno, String cName, int credit, String dName, String tName, int time, int startWeek, int endWeek, int dayOfWeek, int remainPeople, String flag) {
        this.cno = cno;
        this.cName = cName;
        this.credit = credit;
        this.dName = dName;
        this.tName = tName;
        this.time = time;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.dayOfWeek = dayOfWeek;
        this.remainPeople = remainPeople;
        this.flag = flag;

    }

    public StudentCourse(String sno, String sName, String cno, int semester, int grade,int remainPeople,int totalPeople) {
        this.sno = sno;
        this.sName = sName;
        this.cno = cno;
        this.semester = semester;
        this.grade = grade;
        this.remainPeople = remainPeople;
        this.totalPeople = totalPeople;
    }
}
