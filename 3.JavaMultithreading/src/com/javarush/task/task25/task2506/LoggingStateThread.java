package com.javarush.task.task25.task2506;

/**
 * Created by sharka on 12.03.2017.
 */
public class LoggingStateThread extends Thread {
    private Thread logTarget;

    public LoggingStateThread(Thread target) {
        logTarget=target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State lastState;

        lastState = logTarget.getState();
        System.out.println(lastState);

        while (lastState!=State.TERMINATED) {
                if (lastState!=logTarget.getState()) {
                    System.out.println(logTarget.getState());
                    lastState = logTarget.getState();
                }
        }
    }
}
