package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printStack(e);
    }

    public void printStack(Throwable e) {
        if (e.getCause()!=null) printStack(e.getCause());
        System.out.println(e);
    }

    public static void main(String[] args) throws Exception {
        Throwable e = new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        new Solution().uncaughtException(Thread.currentThread(), e);
    }
}
