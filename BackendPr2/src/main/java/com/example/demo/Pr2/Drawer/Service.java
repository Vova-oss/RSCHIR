package com.example.demo.Pr2.Drawer;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    public Map<String,String> method(int num){
        num = 63 - num % 63;
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(~num));
        String stroka = binaryString.substring(26, 32);


        int figure = Integer.parseInt(stroka.substring(0,2), 2);
        int numColor = Integer.parseInt(stroka.substring(2,4), 2);
        int size = Integer.parseInt(stroka.substring(4,6), 2) + 1;
        String color = "";
        switch (numColor){
            case 0:
                color = "red";
                break;
            case 1:
                color = "green";
                break;
            case 2:
                color = "blue";
                break;
            case 3:
                color = "yellow";
                break;
        }
        Map<String, String> map = new HashMap<>();
        map.put("figure", String.valueOf(figure));
        map.put("color", color);
        map.put("size", String.valueOf(size));
        return map;
    }

}
