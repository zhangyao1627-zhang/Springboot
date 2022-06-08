package com.neusoft.common.entity;


import com.neusoft.common.validationGroup.DeleteGroup;
import com.neusoft.common.validationGroup.InsertGroup;
import com.neusoft.common.validationGroup.SelectGroup;
import com.neusoft.common.validationGroup.UpdateGroup;
import com.neusoft.menu.entity.Menu;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class User {

    @NotNull(message = "The user id is required", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    @NotEmpty(message = "The user id is mandatory", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    String userid;
    String username;
    @NotNull(message = "The password is required", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    @NotEmpty(message = "The password is mandatory", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    String password;
    int usertypeid;
    List<Menu> menus;
}
