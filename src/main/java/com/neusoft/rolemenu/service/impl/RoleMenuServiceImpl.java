package com.neusoft.rolemenu.service.impl;

import com.neusoft.rolemenu.mapper.RoleMenuMapper;
import com.neusoft.rolemenu.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public List<Integer> getMenuIds(Integer usertypeid) {
        return roleMenuMapper.getMenuIds(usertypeid);
    }
}
