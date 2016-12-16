package com.alexey;


import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    String st;
    int time,memory;



    public static void optim(List<Comp> mass){
        int comp = 1024;
    ArrayList<Comp> fortime = new ArrayList<>();
    ArrayList<List<Comp>> result = new ArrayList<>();
        int counter = 0;
        while(!mass.isEmpty()){
        result.add(new ArrayList<>());
        result.get(counter).add(mass.get(0));
        int det = comp - mass.get(0).getMemory();
        for(int i =1;i<mass.size();i++){
            if(mass.get(i).getMemory() <= det){
                fortime.add(mass.get(i));
            }
        }
        if(fortime.isEmpty()){
            mass.remove(0);
            counter++;
        }
        else {
            Comp vrem = fortime.get(0);
            for (int i = 1; i < fortime.size(); i++) {
                if (vrem.getMemory() > fortime.get(i).getMemory()) {
                    vrem = fortime.get(i);
                }
            }
            for (int i = 0; i < mass.size(); i++) {
                if (vrem.getName().compareTo(mass.get(i).getName()) == 0) {
                    result.get(counter).add(mass.get(i));
                    mass.remove(i);
                }
            }
            fortime.clear();
            mass.remove(0);
            counter++;
        }
    }
        for(int i =0;i<result.size();i++){
        System.out.println(result.get(i));
        }
    }

  

}
