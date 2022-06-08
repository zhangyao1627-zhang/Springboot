package com.neusoft.rolemenu.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuService {
    List<Integer> getMenuIds(Integer usertypeid);
}
