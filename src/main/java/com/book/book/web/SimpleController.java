package com.book.book.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author anand.
 * since on 17/3/18.
 */
@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;

    @RequestMapping("/")
    public String homePage(Model model){
        model.addAttribute("appName",appName);
        return "home";
    }
}
