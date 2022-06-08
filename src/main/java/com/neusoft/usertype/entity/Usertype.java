package com.neusoft.usertype.entity;

import com.neusoft.common.validationGroup.DeleteGroup;
import com.neusoft.common.validationGroup.InsertGroup;
import com.neusoft.common.validationGroup.SelectGroup;
import com.neusoft.common.validationGroup.UpdateGroup;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Usertype {
    @NotNull(message = "The user id is required", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    int utid;
    @NotEmpty(message = "The user id is mandatory", groups = {SelectGroup.class, InsertGroup.class, UpdateGroup.class, DeleteGroup.class})
    String utname;
    String menus;
}
