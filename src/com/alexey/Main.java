package com.alexey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static com.alexey.Algorithm.optim;
import static com.alexey.Comp.COMPARE_BY_TIME;
public class Main {
    public static void main(String[] args) {
        int Max = 700;
        int Min = 250;
        int timeMin = 10;
        int timeMax = 60;
        final int count = 10;
        final int comp = 1024;
        List<Comp> mass = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mass.add(new Comp("Process" + i, (Min + (int) (Math.random() * (Max - Min) + 1)), (timeMin + (int) (Math.random() * (timeMax - timeMin) + 1))));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(mass.get(i));
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + mass.get(i).getTime();
        }
        System.out.println("При последовательном выполнении: " + sum + " секунд");
        Collections.sort(mass,Comp.COMPARE_BY_TIME);
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(mass.get(i));
        }
        int temp = comp;
        for(int i =0;i<10;i++){
            if(  mass.get(i).getMemory()< temp)
                temp = mass.get(i).getMemory();
        }
        int minMemory = temp;
        System.out.println("Min memory: " + minMemory);
        optim(mass);
        }
    }
