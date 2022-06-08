package com.neusoft.student.entity;

import com.neusoft.common.validationGroup.DeleteGroup;
import com.neusoft.common.validationGroup.InsertGroup;
import com.neusoft.common.validationGroup.SelectGroup;
import com.neusoft.common.validationGroup.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Student {
    @NotNull(message = "The user id is required", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    @NotEmpty(message = "The user id is mandatory", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    String id;
    String name;
    String password;
    String gender;

    int usertypeid;
}
