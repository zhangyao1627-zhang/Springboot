package com.neusoft.controller;

import com.neusoft.common.base.BaseController;
import com.neusoft.common.base.BaseModelJsonPaging;
import com.neusoft.common.exception.BusinessException;
import com.neusoft.common.validationGroup.SelectGroup;
import com.neusoft.usertype.entity.Usertype;
import com.neusoft.usertype.service.UsertypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertype")
public class UsertypeController extends BaseController {

    @Autowired
    UsertypeService usertypeService;

    @GetMapping("/getUsertypes")
    public BaseModelJsonPaging<List<Usertype>> getUsertypes() {
        List<Usertype> datas = usertypeService.getAll();
        BaseModelJsonPaging<List<Usertype>> baseModel = new BaseModelJsonPaging<>();
        baseModel.data = datas;
        baseModel.code = 200;

        return baseModel;
    }

    @PostMapping("/getUsertype")
    public String getUsertypes(@Validated({SelectGroup.class}) @RequestBody Usertype usertype,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USER_INVALID.newInstance(this.getErrorResponse(bindingResult),
                    new Object[]{usertype.toString()});
        } else {
            System.out.println(usertype);
        }
        return usertype.toString();
    }
}
