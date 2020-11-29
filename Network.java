package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network
{
    private static final String SERVER_ADRESS = "localhost";
    private static final int SERVER_PORT = 8189;

    private final String host;
    private final int port;

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    private Socket socket;

    public DataOutputStream getDataOutputStream()
    {
        return dataOutputStream;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Network()
    {
     this(SERVER_ADRESS,SERVER_PORT);
    }



    public boolean connect()
    {
        try
        {
            socket = new Socket("localhost",8189);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            return true;
        }
    catch (IOException e)
        {
            System.out.println("Соединение не было установлено ");
            e.printStackTrace();
            return false;
        }
    }



    public void close()
    {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void waitMessage(Controller controller)
    {
        Thread thread = new Thread(() -> {
               try {
                   while (true) {

                       String message = dataInputStream.readUTF();
                       controller.addWordToList(message);
                   }
               }catch (IOException e)
               {
                   e.printStackTrace();
               }
        });
    }
}
