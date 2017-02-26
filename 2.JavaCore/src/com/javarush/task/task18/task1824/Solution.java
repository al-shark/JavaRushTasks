package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream stream;
        String fn="";
        while (true) {
            try {
                fn = reader.readLine();
                stream = new FileInputStream(fn);
                stream.close();
            }
            catch (FileNotFoundException e)           {
                System.out.println(fn);
                reader.close();
                break;
            }
        }
    }
}
