package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Quentin on 15/11/2014.
 */
public class MultiServerThread extends Thread {

    private Socket serverSocket = null;
    private RequestTreatment requestTreatment;

    public MultiServerThread(Socket socket) {
        super("MultiServerThread");
        this.serverSocket = socket;
        requestTreatment = new RequestTreatment();

    }

    public void run() {
        ObjectInputStream inFromClient = null;
        Request request = null;
        try {
            System.out.println("TEST");
            while(true) {
            inFromClient = new ObjectInputStream(serverSocket.getInputStream());
            try {
                request = (Request) inFromClient.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

                ObjectOutputStream outFromClient = new ObjectOutputStream((serverSocket.getOutputStream()));

                Answer answer = requestTreatment.getInfo(request);
                //Answer answer = new Answer();
                outFromClient.writeObject(answer);
                System.out.println("Received: " + request.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
