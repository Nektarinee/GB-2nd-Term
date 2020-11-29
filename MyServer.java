package chat;

import chat.auth.BaseAuthService;
import chat.handler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final ServerSocket serverSocket;
    private final BaseAuthService authService;
    private final List<ClientHandler> clients = new ArrayList<>();



    public MyServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.authService = new BaseAuthService();
    }

    public void start() throws IOException {
        System.out.println("Сервер запущен!");

        try {
            while (true) {
                waitAndProcessNewClientConnection();

            }
        }catch (IOException e)
        {
            System.out.println("Ошибка создания нового подключения!");
            e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }
    }

    private void waitAndProcessNewClientConnection() throws IOException {
        System.out.println("Ожидание пользователя...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Клиент подключился!");
        processClientConnection(clientSocket);
    }

    private void processClientConnection(Socket clientSocket) throws IOException {
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public BaseAuthService getAuthService() {
        return authService;
    }

    public boolean isUsernameBusy(String clientUserName)
    {
        for(ClientHandler client : clients)
        {
            if (client.getClientUserName().equals(clientUserName))
            {
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler clientHandler)
    {
        clients.add(clientHandler);
    }

    public void unSubscribe(ClientHandler clientHandler)
    {
        clients.remove(clientHandler);
    }


    public void broadcastMessage(String s, ClientHandler sender) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender)
            {
                continue;
            }
            client.sendMessage(s);
        }
    }
}
