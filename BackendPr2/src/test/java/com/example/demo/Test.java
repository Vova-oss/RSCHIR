package com.example.demo;

import com.example.demo.Pr2.Unix.UnixController;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
public class Test {

    @Autowired
    UnixController unixController;

    @Mock
    Model model;
    @org.junit.jupiter.api.Test
    void contextLoads() {
        unixController.getInfo(model, "cmd /c echo dk");
    }


}
