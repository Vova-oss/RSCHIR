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
        int [] arrayI = new int[0];
        String[] arrayS = new String[0];


        for(int i=0;i< newMass.length;i++){
            try {
                int temp = Integer.parseInt(newMass[i]);
                int[] tempArr = arrayI.clone();
                arrayI = new int[arrayI.length+1];
                for(int j = 0;j<tempArr.length;j++)
                    arrayI[j] = tempArr[j];

                arrayI[arrayI.length - 1] = temp;
            }catch (Exception e){
                String[] tempArr = arrayS.clone();
                arrayS = new String[arrayS.length+1];
                for(int j = 0;j<tempArr.length;j++)
                    arrayS[j] = tempArr[j];

                arrayS[arrayS.length - 1] = newMass[i];
            }
        }

        for (int i = 0; i < arrayI.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = arrayI[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < arrayI.length; j++) {
                if (arrayI[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = arrayI[j];
                }
            }
            arrayI[pos] = arrayI[i];
            arrayI[i] = min;    // меняем местами наименьший с array[i]
        }

        for (int i = 0; i < arrayS.length; i++) {    // i - номер текущего шага
            int pos = i;
            String min = arrayS[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < arrayS.length; j++) {
                if (arrayS[j].compareTo(min)<0) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = arrayS[j];
                }
            }
            arrayS[pos] = arrayS[i];
            arrayS[i] = min;    // меняем местами наименьший с array[i]
        }

        String [] array = new String[arrayI.length+arrayS.length];
        for(int i = 0;i<arrayI.length;i++){
            array[i] = String.valueOf(arrayI[i]);
        }

        for(int i = arrayI.length; i<array.length;i++){
            array[i] = arrayS[i- arrayI.length];
        }

        model.addAttribute("array",array);
        return "sort";

    }

}
