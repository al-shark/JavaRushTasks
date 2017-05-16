package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by sharka on 16.05.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            if (message!=null) {
                ConsoleHelper.writeMessage(message);

                if (message.contains(":")) {
                    String[] part = message.split(":", 2);
                    String userName = part[0].trim();
                    String userCommand = part[1].trim();
                    boolean isCommand = true;
                    String formatString = "";
                    switch (userCommand) {
                        case "дата":
                            formatString = "d.MM.YYYY";
                            break;
                        case "день":
                            formatString = "d";
                            break;
                        case "месяц":
                            formatString = "MMMM";
                            break;
                        case "год":
                            formatString = "YYYY";
                            break;
                        case "время":
                            formatString = "H:mm:ss";
                            break;
                        case "час":
                            formatString = "H";
                            break;
                        case "минуты":
                            formatString = "m";
                            break;
                        case "секунды":
                            formatString = "s";
                            break;
                        default:
                            isCommand = false;
                    }

                    if (isCommand) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
                        sendTextMessage("Информация для " + userName + ": " + dateFormat.format(Calendar.getInstance().getTime()));
                    }
                }
            }
        }
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
