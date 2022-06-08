package com.neusoft.teacher.service.impl;

import com.neusoft.student.entity.Student;
import com.neusoft.teacher.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> getAll(Map<String,Object> map);
}
