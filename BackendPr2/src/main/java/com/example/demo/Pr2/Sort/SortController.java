package com.example.demo.Pr2.Sort;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;

@org.springframework.stereotype.Controller
public class SortController {

    @GetMapping("/sort")
    public String sort(Model model,
                          @PathParam("mass") String mass){

        String [] newMass = mass.split(",");
        int [] array = new int[newMass.length];
        for(int i=0;i< newMass.length;i++){
            array[i] = Integer.parseInt(newMass[i]);
        }

        for (int i = 0; i < array.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = array[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = min;    // меняем местами наименьший с array[i]
        }

        model.addAttribute("array",array);
        return "sort";

    }

}
