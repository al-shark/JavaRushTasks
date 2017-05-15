package com.javarush.task.task30.task3008.client;

/**
 * Created by sharka on 16.05.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

    }

    @Override
    protected String getUserName() {
        return "date_bot_"+ (int) (100*Math.random());
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main (String[] args) {
        BotClient client = new BotClient();
        client.run();
    }
}
