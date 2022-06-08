package com.neusoft.common.base;

import com.neusoft.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

public class BaseController {
    Logger logger = LoggerFactory.getLogger(BusinessException.class);

    @ExceptionHandler
    @ResponseBody
    public BaseModel exp(HttpServletRequest request, HttpServletResponse response,
                         Exception exception) {
        BaseModel baseModel = new BaseModel();
        if (exception instanceof BusinessException) {
            baseModel.message = exception.getMessage();
            baseModel.code = ((BusinessException) exception).getCode();
            this.logger.error("errormessage:{}", baseModel.toString());
        }
        else if (exception instanceof NoHandlerFoundException) {
            baseModel.message = exception.getMessage();
            baseModel.code = 404;
            this.logger.error("errormessage:{}", baseModel.toString());
        }else{
            {
                baseModel.message = "There is system error!!!";
                baseModel.code = 500;
                this.logger.error("errormessage:{}", baseModel.toString());
            }
        }
        return baseModel;
    }

    //BindingResult
    public String getErrorResponse(BindingResult bindingResult){
        StringBuffer sbu = new StringBuffer();
        Iterator iterator = bindingResult.getAllErrors().iterator();
        while (iterator.hasNext()){
            ObjectError objectError = (ObjectError) iterator.next();
            this.logger.info(objectError.getCode());
            this.logger.info(objectError.getDefaultMessage());
            sbu.append(objectError.getDefaultMessage()).append(",");
        }
        sbu.delete(sbu.length()-1,sbu.length());
        return sbu.toString();
    }
}
