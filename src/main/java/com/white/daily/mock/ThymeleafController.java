package com.white.daily.mock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tcs
 * @date Created in 2021-04-06
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/hehe")
    public String gg(){
        return "hello";
    }
}
