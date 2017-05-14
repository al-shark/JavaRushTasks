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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message;
            String userName = "";

            while ("".equals(userName)) {
                message = new Message(MessageType.NAME_REQUEST);
                connection.send(message);
                message = connection.receive();
                if (MessageType.USER_NAME.equals(message.getType())) {
                    userName = message.getData().trim();
                    if (!("".equals(userName)) && !(connectionMap.containsKey(userName))) {
                        connectionMap.put(userName,connection);
                        message = new Message(MessageType.NAME_ACCEPTED);
                        connection.send(message);
                    } else userName = "";
                }
            }

            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            Message message;
            for (Map.Entry<String,Connection> user : connectionMap.entrySet()) {
                if (!userName.equals(user.getKey())) {
                    message = new Message(MessageType.USER_ADDED,user.getKey());
                    connection.send(message);
                }
            }
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
