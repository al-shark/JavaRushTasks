package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sIn = reader.readLine();
        reader.close();

        String test="";
        BufferedReader fIn= new BufferedReader(new FileReader(sIn));
        while (fIn.ready()) test=test+fIn.readLine()+" ";
        fIn.close();

        test=test.trim();

        int idx=0;
        String tag = args[0].toLowerCase();
        String work = test.toLowerCase();
        TreeMap<Integer,Tag> map = new TreeMap<>();
        int curIdx,lstIdx=0,stack=0;
        Stack<Tag> st = new Stack<>();
        Tag tTag;

        while (true) {
            curIdx=work.indexOf(tag,lstIdx);
            if (curIdx==-1) break;
            if (isOTag(tag,work,curIdx)) {
                tTag=new Tag(idx,curIdx-1,0);
                st.push(tTag);
                idx++;
            } else if (isCTag(tag,work,curIdx)) {
                tTag=st.pop();
                tTag.setL(curIdx+tag.length()+1);
                map.put(tTag.getInd(),tTag);
            }
            lstIdx=curIdx+tag.length()+1;
        }


        for (Map.Entry<Integer,Tag> x : map.entrySet()) {
            tTag=x.getValue();
            System.out.println(test.substring(tTag.getB(),tTag.getL()));
        }


    }

    public static boolean isOTag(String tag, String s, int p) {
        boolean result=false;
        String ftag = "<"+tag+">";
        if (ftag.equals(s.substring(p-1,p+tag.length()+1).replaceAll(" ",">"))) result=true;
        return result;
    }

    public static boolean isCTag(String tag, String s, int p) {
        boolean result=false;
        String ftag = "</"+tag+">";
        if (ftag.equals(s.substring(p-2,p+tag.length()+1))) result=true;
        return result;
    }

    public static class Tag {
        private int ind;
        private int b;
        private int l;

        public Tag(int ind, int b, int l) {
            this.ind = ind;
            this.b = b;
            this.l = l;
        }

        public int getB() {
            return b;
        }

        public int getL() {
            return l;
        }

        public void setB(int b) {
            this.b = b;
        }

        public void setL(int l) {
            this.l = l;
        }

        public int getInd() {
            return ind;
        }

        public void setInd(int ind) {

            this.ind = ind;
        }
    }

}
