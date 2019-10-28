package com.yt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @ResponseBody
    @RequestMapping("/buy")
    public String buy(){
        return "pay successful...";
    }

    @RequestMapping("/ok")
    public String ok(){
        return "ok"; //到我们自定义的子容器appconfig中找到WEB-INF/pages/ok.jsp
    }
}
