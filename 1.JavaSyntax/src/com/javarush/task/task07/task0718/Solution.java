package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
               BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                ArrayList<String> str = new ArrayList<>(10);
                int pos = 0;

        for (int i=0; i<10;i++) str.add(i,reader.readLine());
        reader.close();

                for (int i=1; i<10;i++)
                {
                    if (str.get(i).length()<str.get(i-1).length())
                    {
                        System.out.println(i);
                        break;
                    }
                }
                //напишите тут ваш код
            }
        }
