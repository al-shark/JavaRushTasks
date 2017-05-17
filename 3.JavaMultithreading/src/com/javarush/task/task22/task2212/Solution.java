package com.javarush.task.task22.task2212;

import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null) return false;
        String str = telNumber.replaceAll(" ","");
        int tLen = str.replaceAll("\\D","").length();
        if (!(str.charAt(0)=='+' && tLen==12) && !(tLen==10)) return false;
        if (telNumber.matches("\\+\\d+(\\([0-9]{3}\\))?\\d+(-)?(\\d+)(-)?(\\d+)")) return true;
        if (telNumber.matches("(\\([0-9]{3}\\))?\\d+-?(\\d+)-?\\d+")) return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber(")050(1234567"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));
        System.out.println(checkTelNumber("(050)1-23456-7"));
        System.out.println(checkTelNumber("(050)-1234567"));
        System.out.println(checkTelNumber("050-1-2(345)67"));
    }
}
