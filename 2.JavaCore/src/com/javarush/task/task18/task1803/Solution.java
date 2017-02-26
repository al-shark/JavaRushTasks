package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int max = 1;
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

            if (max<byt.get(b)) max=byt.get(b);
        }

        inputStream.close();

        for (Map.Entry<Integer,Integer> x : byt.entrySet() )
        {
            if (x.getValue()==max) System.out.print(x.getKey()+" ");
        }

    }
}
