package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread x : threads) {
            Thread.State threadState = x.getState();

            switch (threadState) {
                case NEW:
                    x.start();
                    break;
                case TERMINATED:
                    System.out.println(x.getPriority());
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    x.interrupt();
                    break;
                case RUNNABLE:
                    x.isInterrupted();
            }
        }
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
    }
}
