package com.satori.meow.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YanFuYou
 * @date 16/01/24 下午 11:11
 */

@Controller
@RequestMapping("/test")
public class TestController {


    @GetMapping("/login")
    public String login(){


        return "redirect:https://www.baidu.com/";
    }
}
