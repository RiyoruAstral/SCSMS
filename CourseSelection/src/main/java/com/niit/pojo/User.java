package com.niit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Data
public class User {
    private int userId;
    private String username;
    private String password;
    private String userType;
    private String otherNo;

    private String name;

    public User(int userId, String username, String password, String userType, String otherNo) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.otherNo = otherNo;
    }

}
