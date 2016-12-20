package com.alexey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.alexey.Algorithm.optim;
public class Main {
    public static void main(String[] args) {
        final int comp = 1024;
        int Max = (int) (0.7*comp);
        int Min = (int) (0.2*comp);
        int timeMin = 10;
        int timeMax = 60;
        final int count = 10;
        System.out.println("Компьютер со следующими характеристиками: Частота процессора: 2,3 ГГц;Оперативная память " + comp + " Мб");
        System.out.println("Необходимо последовательно выполнить следующие процессы:");
        ArrayList<List<Comp>> Answer;
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
        System.out.println("Если эти процессы будут выполняться последовательно, то это займет " + sum + " секунд");
        Collections.sort(mass,Comp.COMPARE_BY_TIME);
        System.out.println();

        Answer = optim(mass);

        int generally = 0;
        for(int i = 0;i<Answer.size();i++){

            System.out.println("За " +  FindMax(Answer.get(i)) + " сек. будут параллельно " +
                    "выполнены следующие процессы: ");
           for(int j =0;j<Answer.get(i).size();j++){
                System.out.printf("%s, ", Answer.get(i).get(j).getName());
            }
            generally += FindMax(Answer.get(i));
            System.out.println();

        }
        System.out.println("Общее время при параллельном выполнении: " + generally + " сек.");
        System.out.println("Разница по времени: " + (sum - generally) + " сек." );
    }
        public static int FindMax(List<Comp> arr){
            int max = arr.get(0).getTime();
            for(int i =0;i < arr.size();i++){
                if(arr.get(i).getTime() > max){
                    max = arr.get(i).getTime();
                }
            }
            return max;
        }

        
    }
