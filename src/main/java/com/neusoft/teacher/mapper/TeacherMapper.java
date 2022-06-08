package com.neusoft.teacher.mapper;

import com.neusoft.common.base.BaseMapper;

import com.neusoft.teacher.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends BaseMapper<Integer, Teacher> {

}
