package com.neusoft.rolemenu.mapper;

import com.neusoft.common.base.BaseMapper;
import com.neusoft.rolemenu.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMenuMapper extends BaseMapper<Integer, RoleMenu> {

    @Select("select menuid from sys_role_menu where usertypeid= #{usertypeid}")
    List<Integer> getMenuIds(@Param("usertypeid") Integer usertypeid);
}
