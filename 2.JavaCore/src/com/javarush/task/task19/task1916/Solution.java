package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        ArrayList<String> s1 = new ArrayList<>();
        reader = new BufferedReader(new FileReader(f1));
        while (reader.ready()) s1.add(reader.readLine());
        reader.close();

        ArrayList<String> s2 = new ArrayList<>();
        reader = new BufferedReader(new FileReader(f2));
        while (reader.ready()) s2.add(reader.readLine());
        reader.close();

        String str1,str2;
        for (int i=0; i<s1.size();i++) {
            str1=s1.get(i);
            if (s2.size()==0) {
                lines.add(new LineItem(Type.REMOVED,str1));
                continue;
            }
            if (str1.equals(s2.get(0))) {
                lines.add(new LineItem(Type.SAME,str1));
                s2.remove(0);
            }
            else if (str1.equals(s2.get(1))) {
                lines.add(new LineItem(Type.ADDED,s2.get(0)));
                s2.remove(0);
                i--;
            }
            else lines.add(new LineItem(Type.REMOVED,str1));
        }
        for (String x : s2) lines.add(new LineItem(Type.ADDED,x));

        for (LineItem x : lines) System.out.println(x.type.toString()+" "+x.line);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
