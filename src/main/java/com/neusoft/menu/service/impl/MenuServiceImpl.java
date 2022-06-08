package com.neusoft.menu.service.impl;

import com.neusoft.menu.entity.Menu;
import com.neusoft.menu.mapper.MenuMapper;
import com.neusoft.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus(String menuname) {
        return menuMapper.getMenus(menuname);
    }
}
