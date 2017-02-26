package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double ind = weight/(height*height);
            String res = "";
            if (ind>29.9) res="Ожирение: 30 или больше";
            else if (ind>24.9) res="Избыточный вес: между 25 и 29.9";
            else if (ind<18.5) res="Недовес: меньше чем 18.5";
            else res="Нормальный: между 18.5 и 24.9";
            System.out.println(res);
            //напишите тут ваш код
        }
    }
}
