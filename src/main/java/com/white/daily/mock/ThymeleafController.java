package com.white.daily.mock;

import com.white.daily.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    private String show(@RequestParam("name")String name, @RequestParam("age")int age, ModelMap map){
        User user = new User();
        user.setUsername(name);
        user.setAge(age);
        map.addAttribute("user",user);
        return "index";
    }
}
