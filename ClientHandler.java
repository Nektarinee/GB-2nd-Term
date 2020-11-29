package chat.handler;

import chat.MyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private static final String AUTH_CMD_PREFIX = "/auth";
    private static final String AUTHOK_CMD_PREFIX = "/authok";
    private static final String AUTHERR_CMD_PREFIX = "/autherr";


    private final Socket clientSocket;
    private final MyServer myServer;
    private DataInputStream in;
    private DataOutputStream out;
    private String clientUserName;


    public ClientHandler(MyServer myServer, Socket clientSocket)
    {
        this.myServer = myServer;
        this.clientSocket = clientSocket;

    }

    public void handle() throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() ->
        {
            try {
                authentification();
                readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


    }

    private void authentification() throws IOException
    {
        String message = in.readUTF();
        while (true)
        {
            if (message.startsWith(AUTH_CMD_PREFIX))
            {
                String[] parts = message.split("\\s +" ,3);
                String login = parts[1];
                String password = parts[2];

                this.clientUserName = myServer.getAuthService().getUserNameByLoginAndPassword(login,password);

                if (clientUserName != null)
                {
                    if (myServer.isUsernameBusy(clientUserName))
                    {
                        out.writeUTF(AUTHERR_CMD_PREFIX +  "Логин уже используется");
                    }
                    out.writeUTF(AUTHOK_CMD_PREFIX + "" + clientUserName);
                    myServer.subscribe(this);
                    myServer.broadcastMessage(clientUserName + " присоединился к чату!" , this);
                    break;
                }

                    else
                        {
                            out.writeUTF(AUTHERR_CMD_PREFIX + "Логин или пароль не соответствуют" + clientUserName);
                        }

            }
        }

    }

    private void readMessage() throws IOException {
        while (true)
        {
            String message = in.readUTF();
            System.out.println("message | " + clientUserName + ": " + message);
            if (message.startsWith("/end"))
            {
                return;
            }
            myServer.broadcastMessage(message,this);

        }

    }

    public String getClientUserName()
    {
        return clientUserName;
    }

    public void sendMessage(String s) throws IOException {
        out.writeUTF(s);
    }
}
