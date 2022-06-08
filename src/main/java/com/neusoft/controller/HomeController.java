package com.neusoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //=@Controller+@ResponseBody
@RequestMapping("/home")
public class HomeController {

    @RequestMapping("/showHome")
//    @ResponseBody
    public String showHome() {
        return "hello world";
    }

    @GetMapping("/getNameById/{uid}")
//    @ResponseBody
    public String getNameById(@PathVariable("uid") String uid) {
        return uid;
    }
}
