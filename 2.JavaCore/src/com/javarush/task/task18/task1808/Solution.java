package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(f1);
        FileOutputStream outputStream1 = new FileOutputStream(f2);
        FileOutputStream outputStream2 = new FileOutputStream(f3);

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream1.write(buffer, 0, count/2+(count % 2));
            outputStream2.write(buffer, count/2+(count % 2), count/2);
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }
}
