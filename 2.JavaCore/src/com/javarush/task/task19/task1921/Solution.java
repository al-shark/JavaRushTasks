package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        String fName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fName));

        String str="";
        String sName;
        Date dBirth;
        int iStrLen=0;
        String[] strings;
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

        while (reader.ready()) {
            str = reader.readLine();
            strings = str.split(" ");
            iStrLen = strings.length;
            dBirth = dateFormat.parse(toFixStr(strings[iStrLen-3],2)+" "+toFixStr(strings[iStrLen-2],2)+" "+toFixStr(strings[iStrLen-1],4));
            sName = "";
            for (int i=0;i<(iStrLen-3);i++) sName=sName+" "+strings[i];
            sName=sName.trim();
            PEOPLE.add(new Person(sName,dBirth));
        }
        reader.close();
    }

    public static String toFixStr (String s, int l) {
        String res = s;
        for (int i=s.length();i<l;i++) res="0"+res;
        return res;
    }
}
