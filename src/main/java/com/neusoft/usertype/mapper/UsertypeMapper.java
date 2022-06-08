package com.neusoft.usertype.mapper;

import com.neusoft.common.base.BaseMapper;
import com.neusoft.usertype.entity.Usertype;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface UsertypeMapper extends BaseMapper<Integer, Usertype> {
}
