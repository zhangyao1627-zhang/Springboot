package com.neusoft.student.service;

import com.neusoft.student.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<Student> getAll(Map<String,Object> map);
}
