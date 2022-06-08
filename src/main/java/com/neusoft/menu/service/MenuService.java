package com.neusoft.menu.service;


import com.neusoft.menu.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenus(String menuname);
}
