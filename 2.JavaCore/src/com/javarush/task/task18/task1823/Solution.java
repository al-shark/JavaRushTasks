package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fn = reader.readLine();
        while (!"exit".equals(fn)) {
            new ReadThread(fn).start();
            fn = reader.readLine();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {

        private FileInputStream stream;
        private String fname;

        public ReadThread(String fileName) throws Exception {
            stream = new FileInputStream(fileName);
            fname = fileName;
            //implement constructor body
        }

        @Override
        public void run() {
            int[] count = new int[256];
            int rb;
            try {
                while (stream.available()>0){
                    rb=stream.read();
                    if ((rb>=0) && (rb<256)) count[rb]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxp = 0, maxv=Integer.MIN_VALUE;
            for (int i=0;i<256;i++)
                if (count[i]>maxv) {
                maxv=count[i];
                maxp=i;
                }

            synchronized (resultMap) {
                resultMap.put(fname, maxp);
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
