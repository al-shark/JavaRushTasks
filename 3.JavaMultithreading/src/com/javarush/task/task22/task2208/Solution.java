package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder bStr = new StringBuilder();
        String str;

        for (Map.Entry<String,String> x : params.entrySet()) {
            if (x.getValue()==null) continue;
            if (bStr.length()>0) bStr.append(" and ");
            bStr.append(x.getKey()+" = '"+x.getValue()+"'");
        }

        return bStr.toString();
    }
}
