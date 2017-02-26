package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException,Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f=" ";
        FileInputStream inputStream;

        while (true)
        {
            f=reader.readLine();
            inputStream = new FileInputStream(f);
            if (inputStream.available()<1000)
            {
                reader.close();
                inputStream.close();
                throw new DownloadException();
            }
            else inputStream.close();
        }

    }

    public static class DownloadException extends Exception {

    }
}
