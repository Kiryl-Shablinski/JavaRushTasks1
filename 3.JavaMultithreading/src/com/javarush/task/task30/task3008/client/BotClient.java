package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.lang.String.format;

public class BotClient extends Client{

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return  "date_bot_" + (int) (Math.random()*100);
    }

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
          sendTextMessage("Привет чатику. Я бот. " +
                 "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");

            super.clientMainLoop();

        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (!message.contains(": ")) return;
            String userName = message.substring(0,message.indexOf(": ")).trim();
            String userCommand = message.substring(message.indexOf(": ")+1).trim();
            SimpleDateFormat sdf = null ;


            switch (userCommand){
                case "дата" : sdf = new SimpleDateFormat("d.MM.yyyy");
                    break;
                case "день" : sdf = new SimpleDateFormat("d");
                    break;
                case "месяц" : sdf = new SimpleDateFormat("MMMM");
                    break;
                case "год" : sdf = new SimpleDateFormat("yyyy");
                    break;
                case "время" : sdf = new SimpleDateFormat("H:mm:ss");
                    break;
                case "час" : sdf = new SimpleDateFormat("H");
                    break;
                case "минуты" : sdf = new SimpleDateFormat("m");
                    break;
                case "секунды" : sdf = new SimpleDateFormat("s");
                    break;


            }
           Date curientDate = Calendar.getInstance().getTime();
            if (sdf != null) {
                sendTextMessage(format("Информация для %s: %s",userName, sdf.format(curientDate)));
            }

        }
    }

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }
}
