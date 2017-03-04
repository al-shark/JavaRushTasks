package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        String[] t = getTokens("sfd. werwer .wrwer. wer.werwerwe.werwer.werwer.wer.wer.we.","\\.");
        for (String x : t) System.out.println(x);
    }

    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokens = new StringTokenizer(query,delimiter);
        String[] result = new String[tokens.countTokens()];
        for (int i=0; i<result.length; i++) result[i]=tokens.nextToken();
        return result;
    }
}
