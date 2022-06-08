package com.neusoft.student.mapper;

import com.neusoft.common.base.BaseMapper;
import com.neusoft.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Integer, Student> {

}
