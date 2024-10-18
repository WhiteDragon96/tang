package com.white.daily.mock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tcs
 * @date Created in 2021-05-19
 */
@Controller
public class IndexController {


    @RequestMapping("/comtainer")
    public String container(){
        return "container.html";
    }

    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/static")
    public String statict(){
        return "static.html";
    }
}
