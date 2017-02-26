package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    private static TreeMap<Long,Long> replica = new TreeMap<>();
    private static String s="";
    private static long[][] p = new long[10][19];
    private static int[] n  = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static int[] n1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static int count = 0, nine=0 ;
    private static boolean pos=false;
    static {
        for (int i=1;i<10;i++) {
            p[i][0]=(long)i;
            for (int j=1;j<19;j++) p[i][j]=p[i][j-1]*(long)i;
        }
    }

    public static long[] getNumbers(long N) {

        long sumOfPowers,sumOfPowers1;
        int cc;

        while (count<Long.toString(N).length())
        {
            n[count]=nine;
            sumOfPowers=0;
            for (int k=0; k<=count;k++) sumOfPowers += p[n[k]][count];
            s=Long.toString(sumOfPowers);
            if (s.length()<12 && sumOfPowers>0) {
                for (int k = 0; k < s.length(); k++) n1[k] = Integer.parseInt(s.substring(k, k + 1));
                sumOfPowers1 = 0;
                for (int k = 0; k <= s.length() - 1; k++) sumOfPowers1 += p[n1[k]][s.length()-1];
                if (sumOfPowers == sumOfPowers1) {
                    if (sumOfPowers<=N) replica.put(sumOfPowers, 1l);
                }
            }

            nine++;
            if (nine==10) {
                nine=0;
                cc=0;
                for (int l=count;l>=0;l--){
                    if (n[l]==9) {
                        n[l]=0;
                        cc++;
                    }
                    else {
                        n[l]++;
                        break;
                    }
                }
                if (cc==count+1) {
                    count++;
                    if (pos) {
                        //n[0]++;
                    }
                    pos=!pos;
                }
                for (int l=0;l<cc;l++) n[count-l]=n[count-cc];

                nine=n[count-1];
            }
        }

        long[] result = new long[replica.size()];
        sumOfPowers=0;

        for (Map.Entry<Long,Long> x : replica.entrySet()) {
            result[(int) sumOfPowers]=x.getKey();
            sumOfPowers++;
        }

        return result;
    }


    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long[] mas = getNumbers(Long.MAX_VALUE);
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        long estimatedTime = System.currentTimeMillis() - startTime;
        long totalMem = Runtime.getRuntime().totalMemory();
        long freeMem = Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.println(String.format("Mem : %.2f  Mb.", 1.0 * (totalMem - memoryStart )/ (1024 * 1024)));
        System.out.println(String.format("Time: %.3f sec.", estimatedTime / 1000.0));
    }
}
