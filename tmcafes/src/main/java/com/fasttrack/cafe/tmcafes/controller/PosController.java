package com.fasttrack.cafe.tmcafes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PosController {

    @RequestMapping("/test3")
    public String test3(Model model){
        return "/pos/home";
    }

    @RequestMapping("/pos")
    public String home11(Model model){
        return "/pos/home11";
    }

    @RequestMapping("/linhtinh")
    public String linhtinh(Model model){
        return "/pos/linhtinh";
    }

    @RequestMapping("/txt")
    public String logintesst(Model model){
        return "user/logintesst";
    }
}
