package com.alexey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

public class Comp implements Serializable {
    private String name;
    private int memory,time;

   public Comp(String st,int mr,int tm){
       this.name = st;
       this.memory = mr;
       this.time = tm;
   }

   public int getTime(){
       return time;
   }
    public int getMemory(){
        return memory;
    }
    public String getName(){return name;}


    @Override
    public String toString() {
        return "Name: " + name + " Memory: " + memory + " Time: " + time;
    }
    public static final Comparator<Comp> COMPARE_BY_TIME = new Comparator<Comp>() {
        @Override
        public int compare(Comp o1, Comp o2) {
            return o1.getTime() - o2.getTime();
        }
    };
    public int CompareTo(Object obj){
        Comp tmp = (Comp)obj;
        if(this.time < tmp.time)
            return 1;
        else if(this.time > tmp.time)
            return -1;
        else return 0;
    }
}
