package com.neusoft.menu.service.impl;

import com.neusoft.menu.entity.Menu;
import com.neusoft.menu.mapper.MenuMapper;
import com.neusoft.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenus(String menuname) {
        List<Menu> menus = menuMapper.getMenus(menuname);
        System.out.println("---menus---");
        System.out.println(menus);
        List<Menu> parentMenus = menus.stream().filter(menu->menu.getPid()==0).collect(Collectors.toList());
        System.out.println("---parentmenus----");
        System.out.println(parentMenus);
        for(Menu menu:parentMenus){
            menu.setChildren(menus.stream().filter(menu2->menu2.getPid()==menu.getId()).collect(Collectors.toList()));
        }
        return parentMenus;
    }
}
