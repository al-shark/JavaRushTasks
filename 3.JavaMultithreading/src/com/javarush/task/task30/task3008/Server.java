package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sharka on 14.05.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String,Connection> user : connectionMap.entrySet()) {
            try {
                user.getValue().send(message);
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка отправки сообщения пользователю " +user.getKey());
            }
        }
    }

    public static void main (String[] args) {
        int port = ConsoleHelper.readInt();
        try ( ServerSocket socket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");
            while (true) {
                Handler newcli = new Handler(socket.accept());
                newcli.start();
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания сокета");
            e.printStackTrace();
        }
    }
}
