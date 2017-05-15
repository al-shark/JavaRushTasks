package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by sharka on 15.05.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

    }

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT,text));
        }
        catch (IOException e) {
            System.out.println("Ошибка отправки сообщения.");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socket = getSocketThread();
        socket.setDaemon(true);
        socket.start();

        try {
            synchronized (this) {
                wait();
            }

        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Поток прерван");
            System.exit(1);
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");

            String text;
            while (clientConnected) {
                text = ConsoleHelper.readString();
                if ("exit".equals(text)) break;
                if (shouldSendTextFromConsole()) sendTextMessage(text);
            }
        } else {ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");}
    }

    public static void main (String[] args) {
        Client client = new Client();
        client.run();
    }
}
