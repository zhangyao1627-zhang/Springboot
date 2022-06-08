package com.neusoft.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    @ResponseBody
    public void defaultErrorHandler(HttpServletRequest request, HttpServletResponse response,
                                    Exception e) {
        if (e instanceof NoHandlerFoundException) {
            try {
                response.sendRedirect("http://localhost:3000/NotFound222");  //front-end
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
