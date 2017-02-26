package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int min = Integer.MAX_VALUE;
        int b = 0;
        HashMap<Integer,Integer> byt = new HashMap<>();
        String res="";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        while (inputStream.available() > 0) {
            b=inputStream.read();

            if (byt.containsKey(b)) byt.put(b,byt.get(b)+1);
            else byt.put(b,1);
        }

        inputStream.close();

        for (Map.Entry<Integer,Integer> x : byt.entrySet() ) if (min > x.getValue()) min = x.getValue();

        for (Map.Entry<Integer,Integer> x : byt.entrySet() )
        {
            if (x.getValue()==min) System.out.print(x.getKey()+" ");
        }

    }
}
