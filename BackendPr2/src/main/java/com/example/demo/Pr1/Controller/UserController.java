package com.example.demo.Pr1.Controller;

import com.example.demo.Pr1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userService.findAll());
        return "index";
    }

}

