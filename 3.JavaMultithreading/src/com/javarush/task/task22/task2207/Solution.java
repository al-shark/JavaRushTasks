package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();

        reader=new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
        StringBuilder str;
        String[] lineString;
        Map<String,String> tresult = new HashMap<>();
        String tstr;

        while (reader.ready()) {
            lineString=reader.readLine().split(" ");
            for (int i=0; i<lineString.length; i++) {
                str = new StringBuilder(lineString[i]);

                if(!tresult.containsKey(str.toString())) {
                    if (!tresult.containsValue(str.toString())) {
                        if (!tresult.containsKey(str.reverse().toString())) {
                            tresult.put(str.reverse().toString(),"");
                        }
                        else
                        {
                            tresult.put(str.toString(),str.reverse().toString());
                        }
                    }
                } else {
                    tstr=str.toString();
                    if (tstr.equals(str.reverse().toString())) tresult.put(tstr,tstr);
                }
            }
        }
        reader.close();

        for (Map.Entry<String,String> x : tresult.entrySet()) {
            if (!"".equals(x.getValue())) {
                str=new StringBuilder(x.getKey());
                result.add(new Pair(str.toString(),str.reverse().toString()));
            }
        }

        for (Pair x : result) System.out.println(x);

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
