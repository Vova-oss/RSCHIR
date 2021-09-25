package com.example.demo.Pr2.Drawer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.Map;

@org.springframework.stereotype.Controller
public class DrawerController {

    @Autowired
    Service service;

    @GetMapping("/drawer")
    public String drawer(Model model,
                         @PathParam("num") Integer num){
        Map<String, String> map = service.method(num);
        model.addAttribute("figure", map.get("figure"));
        model.addAttribute("color", map.get("color"));
        model.addAttribute("size", Integer.parseInt(map.get("size")));
        return "draw";
    }

}
