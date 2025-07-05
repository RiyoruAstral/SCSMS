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
    private Date createdTime;
    private Date lastLoginTime;
}
