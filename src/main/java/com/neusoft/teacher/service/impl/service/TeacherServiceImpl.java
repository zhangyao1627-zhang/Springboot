package com.neusoft.teacher.service.impl.service;

import com.neusoft.student.entity.Student;
import com.neusoft.student.mapper.StudentMapper;
import com.neusoft.student.service.StudentService;
import com.neusoft.teacher.entity.Teacher;
import com.neusoft.teacher.mapper.TeacherMapper;
import com.neusoft.teacher.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll(Map<String,Object> map) {
        return teacherMapper.getAllByFilter(map);
    }
}
