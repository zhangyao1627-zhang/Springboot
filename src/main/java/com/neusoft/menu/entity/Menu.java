package com.neusoft.menu.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    int id;
    String name;
    String path;
    String icon;
    String description;
    int pid;
    String pagepath;
    int sorrnum;
    List<Menu> children;
}
