package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by daile on 2017/7/20.
 */
@Controller
public class JspController {

    @RequestMapping("jsp")
    public String index(Model model) {

        model.addAttribute("message", "Neeson");

        return "index";
    }
}
