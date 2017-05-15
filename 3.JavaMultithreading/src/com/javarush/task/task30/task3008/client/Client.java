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

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName+" присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName+" покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message = null;
            while (!clientConnected) {
                message = connection.receive();
                if (MessageType.NAME_REQUEST.equals(message.getType())) {
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                } else {if (MessageType.NAME_ACCEPTED.equals(message.getType())) notifyConnectionStatusChanged(true);
                        else throw new IOException("Unexpected MessageType"); }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message = null;
            while (true) {
                message = connection.receive();
                if (MessageType.TEXT.equals(message.getType())) { processIncomingMessage(message.getData());}
                else {
                    if (MessageType.USER_ADDED.equals(message.getType())) { informAboutAddingNewUser(message.getData());}
                    else {
                        if (MessageType.USER_REMOVED.equals(message.getType())) informAboutDeletingNewUser(message.getData());
                        else throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }
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
