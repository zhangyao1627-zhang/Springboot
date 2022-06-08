package com.neusoft.usertype.service.impl;

import com.neusoft.usertype.entity.Usertype;
import com.neusoft.usertype.mapper.UsertypeMapper;
import com.neusoft.usertype.service.UsertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UsertypeService")
public class UsertypeServiceImpl implements UsertypeService {

    @Autowired
    UsertypeMapper usertypeMapper;

    @Override
    public List<Usertype> getAll() {
        return usertypeMapper.getAll();
    }
}
