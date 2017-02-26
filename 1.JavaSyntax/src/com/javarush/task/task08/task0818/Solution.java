package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String,Integer> m = new HashMap<>();
        m.put("Ivanov",100);
        m.put("Petrov",200);
        m.put("Sidorov",300);
        m.put("Ivanenko",400);
        m.put("Petrenko",500);
        m.put("Sidorenko",600);
        m.put("Ivan",700);
        m.put("Petro",800);
        m.put("Sidor",900);
        m.put("Mutrov",1000);
        return m;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String,Integer> tm = new HashMap<>();
        for (Map.Entry<String,Integer> x : map.entrySet()) tm.put(x.getKey(),x.getValue());

        for (Map.Entry<String,Integer> x : tm.entrySet())
        {
            if (x.getValue()<500) map.remove(x.getKey());
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {

        HashMap<String,Integer> mmm = createMap();
        removeItemFromMap(mmm);
    }
}