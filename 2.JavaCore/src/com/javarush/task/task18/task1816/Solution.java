package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream(args[0]);
        HashMap<String,Integer> alpha = new HashMap<>();
        int a;
        String k;
        while (stream.available()>0) {
            a=stream.read();
            if ((a > 64 && a <91) || (a > 96 && a < 123)) {
                k = String.valueOf((char) a).toLowerCase();
                if (alpha.containsKey(k)) a=alpha.get(k)+1;
                else a=1;
                alpha.put(k,a);
            }
        }
        stream.close();

        if (alpha.size()>0){
            a=0;
            for (Map.Entry<String,Integer> x : alpha.entrySet()) a=a+x.getValue();
            System.out.println(a);
        }
    }
}
