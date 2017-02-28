package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null) throw new TooShortStringException();

        int spaces=0;
        int sPos=0;

        while ((sPos=string.indexOf(" ",sPos))!=-1) {
            spaces++;
            sPos++;
            if (spaces>4) break;
        }

        if (spaces<4) throw new TooShortStringException();

        if (spaces==4) sPos=string.length()+1;

        return string.substring(string.indexOf(" ")+1,sPos-1);
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
