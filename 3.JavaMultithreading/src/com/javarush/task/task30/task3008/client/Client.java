package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
   protected Connection connection;

   private volatile boolean clientConnected = false;

   protected String getServerAddress(){
       ConsoleHelper.writeMessage("Enter server address: ");
       String address = ConsoleHelper.readString();

       return address;
   }

   protected int getServerPort(){
      ConsoleHelper.writeMessage("Enter server port: ");
       int port = ConsoleHelper.readInt();
       return port;
   }

   protected String getUserName(){
       ConsoleHelper.writeMessage("Enter userName: ");
       String userName = ConsoleHelper.readString();
       return userName;
   }

   protected boolean shouldSendTextFromConsole(){
       return true;
   }

   protected SocketThread getSocketThread(){
       return new SocketThread();
   }

   protected void sendTextMessage(String text) {
      try {
          connection.send(new Message(MessageType.TEXT, text));
      }catch (IOException o){
          ConsoleHelper.writeMessage("Сообение не отправлено");
          clientConnected = false;
      }
   }

   public void run() {
      SocketThread socketThread = getSocketThread();
      socketThread.setDaemon(true);
      socketThread.start();
      try {
          synchronized (this) {
              wait();
              while(clientConnected){
                  String line = ConsoleHelper.readString();
                  if (line.equals("exit")) break;
                  if (shouldSendTextFromConsole()){
                      sendTextMessage(line);
                  }

              }
          }
      }catch (InterruptedException interruptedException){
          ConsoleHelper.writeMessage("Соединение с сервером прервано");

      }

   }

   public class SocketThread extends Thread{

       protected void processIncomingMessage(String message){
           ConsoleHelper.writeMessage(message);
       }

       protected void informAboutAddingNewUser(String userName){
           String text = userName + " присоединился к чату";
           ConsoleHelper.writeMessage(text);
       }

       protected void informAboutDeletingNewUser(String userName){
           String text = userName + " покинул чат";
           ConsoleHelper.writeMessage(text);
       }

       protected void notifyConnectionStatusChanged(boolean clientConnected){

           synchronized (Client.this){
              Client.this.clientConnected = clientConnected;
              Client.this.notify();
           }
       }

       protected void clientHandshake() throws IOException, ClassNotFoundException{
           Message message =  connection.receive();

           while (message.getType() == MessageType.NAME_REQUEST) {
               connection.send(new Message(MessageType.USER_NAME, getUserName()));
               message =  connection.receive();
           }

           if (message.getType() == MessageType.NAME_ACCEPTED) {
               notifyConnectionStatusChanged(true);
               return;
           }else {
                    throw new IOException("Unexpected MessageType");
           }


       }

       protected void clientMainLoop() throws IOException, ClassNotFoundException{
           while(true){
               Message message = connection.receive();
               if (message.getType()==null) throw new IOException("Unexpected MessageType");

               switch (message.getType()){

                   case NAME_ACCEPTED :

                   case NAME_REQUEST :

                   case USER_NAME:
                       throw new IOException("Unexpected MessageType");

                   case TEXT: processIncomingMessage(message.getData());
                   break;

                   case USER_ADDED: informAboutAddingNewUser(message.getData());
                   break;

                   case USER_REMOVED: informAboutDeletingNewUser(message.getData());
                   break;

               }
           }
       }

       @Override
       public void run() {

           try ( Socket clientSocket = new Socket(getServerAddress(),getServerPort())){
              connection = new Connection(clientSocket);
              clientHandshake();
              clientMainLoop();


           }catch (IOException | ClassNotFoundException o){
               notifyConnectionStatusChanged(false);
           }
       }
   }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();


    }

}
