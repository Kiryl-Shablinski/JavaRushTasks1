package com.javarush.task.task30.task3008;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
                     String userName;
                         while (true) {
                      connection.send(new Message(MessageType.NAME_REQUEST));
                    Message  userMessage = connection.receive();
                      if (userMessage.getType().equals(MessageType.USER_NAME)) {
                         userName = userMessage.getData();
                          if (!userName.isEmpty()) {
                              if (!connectionMap.containsKey(userName)) {
                                  connectionMap.put(userName, connection);
                                  connection.send(new Message(MessageType.NAME_ACCEPTED));
                                  ConsoleHelper.writeMessage(userName + " Принято");
                                  break;
                              }
                          }
                      }
              }
            return userName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
          for(String  userKey : connectionMap.keySet()){
              if (!userKey.equals(userName)) {
                  connection.send(new Message(MessageType.USER_ADDED, userKey));
              }

          }
        }

        private void serverMainLoop(Connection connection, String userName)
                throws IOException, ClassNotFoundException{
            Message message = null;
            while (true){
                message = connection.receive();
                if (message.getType()==(MessageType.TEXT)){
                    String messageNew = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT,messageNew));
                }else{
                    ConsoleHelper.writeMessage("Ошибка формата сообщения");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение c " + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection, userName);

                serverMainLoop(connection,userName);
                if (userName!=null) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }

            }catch (IOException o){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");

            }catch (ClassNotFoundException o){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");

            }
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(ConsoleHelper.readInt())){
            System.out.println("Сервер запущен.");
            while (true){
                new Handler(server.accept()).start();
            }

        }catch (IOException o){
            System.err.println();
        }
    }

    public static void sendBroadcastMessage(Message message){

        for(Connection connection : connectionMap.values()) {
            try {
                connection.send(message);

            } catch (IOException o) {
                ConsoleHelper.writeMessage("Сообщение не отправлено");
            }
        }
    }
}
