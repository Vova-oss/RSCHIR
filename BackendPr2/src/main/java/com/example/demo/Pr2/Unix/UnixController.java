package com.example.demo.Pr2.Unix;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Controller
public class UnixController {

    @GetMapping("/unix")
    public String startPage(){
        return "unix";
    }

    @GetMapping("/getInfo")
    public String getInfo(Model model,
                        @RequestParam(name="operation") String operation){
        String line = "Неверная команда";
        try {
            Process p = Runtime.getRuntime().exec(operation);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String temp = in.readLine();
            line = "";
            while (temp != null) {
                line += "\n"+temp;
                System.out.println(line);
                temp = in.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
            model.addAttribute("operation", operation);
            model.addAttribute("info", line);
            return "unix";

    }

}
