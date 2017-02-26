package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        FileInputStream stream = new FileInputStream(args[0]);
        if (stream.available()>0){
            HashMap<Integer,Integer> map = new HashMap<>();
            int key=0;
            while (stream.available()>0){
                key=stream.read();
                if (map.containsKey(key)) map.put(key,map.get(key)+1);
                else map.put(key,1);
            }
            stream.close();

            for (int i=0; i<255; i++){
                if (map.containsKey(i)){
                    System.out.println(Character.toString((char) i)+" "+map.get(i));
                }
            }
        }
    }
}
