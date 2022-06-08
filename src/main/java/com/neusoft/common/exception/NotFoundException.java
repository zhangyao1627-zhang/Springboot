package com.neusoft.common.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class NotFoundException implements ErrorController {

    @ResponseBody
    @RequestMapping("/error")
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = getStatus(request);
        switch (status) {
            case NOT_FOUND:
                try {
                    response.sendRedirect("http://localhost:3000/NotFound111");  //front-end
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            case METHOD_NOT_ALLOWED: {

            }
            default:
                System.out.println("");
        }
        return null;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception e) {
//            LOGGER.warn("")
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
