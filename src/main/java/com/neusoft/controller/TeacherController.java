package com.neusoft.controller;

import com.github.pagehelper.PageInfo;
import com.neusoft.common.base.BaseModelJsonPaging;
import com.neusoft.teacher.entity.Teacher;
import com.neusoft.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyao
 * @create 2022-06-09-16:14
 */

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getTeachers")
    public BaseModelJsonPaging<PageInfo<Teacher>> getTeachers(Integer pageNum, Integer pageSize, String id,
                                                              String password, Integer usertypid) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        map.put("usertypid", usertypid);
        if (null != id && !id.equals("")) {
            map.put("id", "%" + id + "%");
        }
        BaseModelJsonPaging<PageInfo<Teacher>> result = new BaseModelJsonPaging<>();
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        result.code = 200;
        result.data = teacherService.getAllByFilter(pageNum, pageSize, map);

        return result;

    }
}
