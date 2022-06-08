package com.neusoft.teacher.entity;

import lombok.Data;

@Data
public class Teacher {
    String id;
    String name;
    String password;
    String title;
    String depart;

    int usertypeid;

}
