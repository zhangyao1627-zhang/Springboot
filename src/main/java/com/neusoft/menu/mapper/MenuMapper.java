package com.neusoft.menu.mapper;

import com.neusoft.common.base.BaseMapper;
import com.neusoft.menu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Integer, Menu> {

    @Select("select * from sys_menu order by sorrnum")
    List<Menu> getMenus(String menuname);

}
