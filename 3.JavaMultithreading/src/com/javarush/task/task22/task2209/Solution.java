package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
        List<String> stringList = new ArrayList<>();
        String[] w;
        while (reader.ready()) {
            w = reader.readLine().split(" ");
            for (int i=0; i<w.length; i++)
                if (!"".equals(w[i].trim())) stringList.add(w[i].trim());
        }
        reader.close();

        String[] words = new String[stringList.size()];
        for (int i=0; i<stringList.size(); i++) words[i]=stringList.get(i);
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length<1) return new StringBuilder();
        StringBuilder buildStr = null;
        boolean[] wUsed = new boolean[words.length];
        int foundCount = 1;
        int lastCount = 0;
        int curpos = 0;
        for (int i=0; i<words.length; i++) {
            buildStr = new StringBuilder();
            buildStr.append(words[i]);
            for (int k=0; k<wUsed.length; k++) wUsed[k]=false;
            wUsed[i]=true;
            curpos=i;
            foundCount=1;
            lastCount =0;
            while (lastCount!=foundCount) {
                lastCount = foundCount;
            for (int j=0; j<words.length; j++) {
                if (!wUsed[curpos] && (words[curpos].substring(0,1).toLowerCase().equals(buildStr.toString().substring(buildStr.toString().length()-1,buildStr.toString().length()).toLowerCase()))) {
                    wUsed[curpos]=true;
                    buildStr.append(" "+words[curpos]);
                    foundCount++;
                }
                curpos++;
                if (curpos==words.length) curpos=0;
            }
            }
            if (foundCount==words.length) break;
        }

          return buildStr;
    }
}
