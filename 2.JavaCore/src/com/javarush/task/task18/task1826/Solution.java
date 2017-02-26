package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {

    static String secret = "Very Hard Password";
    static int counter = 0;

    public static void main(String[] args) throws Exception {
        String param = args[0];
        String sfIn = args[1];
        String sfOut = args[2];

        FileInputStream fIn = new FileInputStream(sfIn);
        FileOutputStream fOut = new FileOutputStream(sfOut);

        if (fIn.available()>0) {
            int bt;
            while (fIn.available()>0){
                bt=fIn.read();
                if ("-e".equals(param)) fOut.write(Encode(bt));
                else if ("-d".equals(param))fOut.write(Decode(bt));
            }
        }
        fIn.close();
        fOut.close();
    }

    public static int Encode(int b) {
        counter++;
        return b ^ 5;
    }

    public static int Decode (int b) {
        counter++;
        return b ^ 5;
    }

}
