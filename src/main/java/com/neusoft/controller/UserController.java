package com.neusoft.controller;

import com.neusoft.common.base.BaseController;
import com.neusoft.common.base.BaseModelJsonPaging;
import com.neusoft.common.entity.User;
import com.neusoft.common.exception.BusinessException;
import com.neusoft.common.validationGroup.SelectGroup;
import com.neusoft.menu.entity.Menu;
import com.neusoft.menu.service.MenuService;
import com.neusoft.rolemenu.service.RoleMenuService;
import com.neusoft.student.entity.Student;
import com.neusoft.student.service.StudentService;
import com.neusoft.teacher.entity.Teacher;
import com.neusoft.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    MenuService menuService;
    @Autowired
    RoleMenuService roleMenuService;

    @PostMapping("/checkUser")
    public BaseModelJsonPaging checkUser(@Validated({SelectGroup.class}) @RequestBody User user,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USER_INVALID.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{user.toString()});
        } else {
            int usertypeid = user.getUsertypeid();
            Map<String, Object> map = new HashMap<>();
            map.put("id", user.getUserid());
            map.put("password", user.getPassword());
            map.put("usertypeid", usertypeid);
            if (usertypeid == 1 || usertypeid == 2) {
                List<Student> students = studentService.getAll(map);
                if (students == null || students.size() == 0) {
                    throw BusinessException.USER_NOT_EXISTS;
                } else {
                    Student student = students.get(0);
                    user.setUserid(student.getId());
                    user.setUsername(student.getName());
                    List<Menu> roleMenus = getRoleMenus(usertypeid);
                    user.setMenus(roleMenus);
                    BaseModelJsonPaging<User> baseModel = new BaseModelJsonPaging<>();
                    baseModel.data = user;
                    baseModel.code = 200;
                    return baseModel;
                }
            } else {
                List<Teacher> teachers = teacherService.getAll(map);
                if (teachers == null || teachers.size() == 0) {
                    throw BusinessException.USER_NOT_EXISTS;
                } else {
                    Teacher teacher = teachers.get(0);
                    user.setUserid(teacher.getId());
                    user.setUsername(teacher.getName());
                    List<Menu> roleMenus = getRoleMenus(usertypeid);
                    user.setMenus(roleMenus);
                    BaseModelJsonPaging<User> baseModel = new BaseModelJsonPaging<>();
                    baseModel.data = user;
                    baseModel.code = 200;
                    return baseModel;
                }
            }
        }
    }

    private List<Menu> getRoleMenus(int usertypeid) {
        List<Integer> menuIds = roleMenuService.getMenuIds(usertypeid);
        List<Menu> menus = menuService.getMenus("");
        List<Menu> roleMenus = new ArrayList<>();
        for (Menu menu : menus) {
            if (menuIds.contains((menu.getId()))) {
                roleMenus.add(menu);
            }
            List<Menu> children = menu.getChildren();
            if(children!=null)
                children.removeIf(child -> !menuIds.contains(child.getId()));
        }
        return roleMenus;
    }
}
