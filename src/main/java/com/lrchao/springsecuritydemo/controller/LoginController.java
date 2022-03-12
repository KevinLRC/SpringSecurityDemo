package com.lrchao.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆的Controller
 *
 * @author kevinliu
 * @date 3/7/22 10:47 PM
 * @since v1.0.0
 */

@Controller
public class LoginController {
//    @RequestMapping("login")
//    public String login() {
//        System.out.println("Perform login");
//        return "redirect:main.html";
//    }

    @RequestMapping("toMain")
    public String toMain() {
        System.out.println("Perform login");
        return "redirect:main.html";
    }

    @RequestMapping("toError")
    public String toError() {
        System.out.println("Perform login error");
        return "redirect:error.html";
    }
}
