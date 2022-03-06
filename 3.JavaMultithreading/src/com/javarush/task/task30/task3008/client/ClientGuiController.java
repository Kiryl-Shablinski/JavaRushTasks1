package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client{
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);


    public ClientGuiModel getModel() {
        return model;
    }

    public ClientGuiView getView() {
        return view;
    }

    public void setView(ClientGuiView view) {
        this.view = view;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public static void main(String[] args) {
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }

    public class GuiSocketThread extends SocketThread{

        public void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();

       }

       public void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
       }

       public void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
       }

       public void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
       }

    }
}
