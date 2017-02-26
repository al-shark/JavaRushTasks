package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String s1,s2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s1 = reader.readLine();
        s2 = reader.readLine();
        byte[] f1 = null;
        byte[] f2 = null;

        int count1=0,count2=0;
        boolean has1=false,has2=false;

        FileInputStream file1 = new FileInputStream(s1);
        if (file1.available()>0)       {
            has1=true;
            count1 = file1.available();
            f1 = new byte[count1];
            count1=file1.read(f1);
        }
        file1.close();

        FileInputStream file2 = new FileInputStream(s2);
        if (file2.available()>0)       {
            has2=true;
            count2 = file2.available();
            f2 = new byte[count2];
            count2=file2.read(f2);
        }
        file2.close();

        FileOutputStream file3 = new FileOutputStream(s1);
        if (has2) file3.write(f2,0,count2);
        if (has1) file3.write(f1,0,count1);
        file3.close();
    }
}
