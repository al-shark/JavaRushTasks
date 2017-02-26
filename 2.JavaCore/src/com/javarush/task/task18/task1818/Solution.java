package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        String f1,f2,f3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        f1 = reader.readLine();
        f2 = reader.readLine();
        f3 = reader.readLine();
        FileOutputStream file1 = new FileOutputStream(f1);
        FileInputStream file2 = new FileInputStream(f2);
        FileInputStream file3 = new FileInputStream(f3);

        int count;
        if (file2.available()>0)    {
            byte[] b2 = new byte[file2.available()];
            count = file2.read(b2);
            file1.write(b2,0,count);
        }
        file2.close();

        if (file3.available()>0) {
            byte[] b3 = new byte[file3.available()];
            count = file3.read(b3);
            file1.write(b3,0,count);
        }
        file3.close();

        file1.close();

    }
}
