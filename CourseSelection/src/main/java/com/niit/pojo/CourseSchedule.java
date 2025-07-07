package com.niit.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class CourseSchedule {
    private String sectionRange;  // 节次范围
    private int startTime;   // 对应映射数字
    private String day;
    private int dayOfWeek;
}
