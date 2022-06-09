package com.neusoft.student.service.impl;

import com.neusoft.student.entity.Student;
import com.neusoft.student.mapper.StudentMapper;
import com.neusoft.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getAll(Map<String,Object> map) {
        return studentMapper.getAllByFilter(map);
    }
}
