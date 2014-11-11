/**
 * Created by Quentin on 03/11/14.
 */
import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String argv[]) throws Exception  {

        Socket clientSocket = new Socket("localhost", 6789);
        Protocole protocole = new Protocole();
        Request request = new Request(10,"test", "test");

        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        outToServer.writeObject(request);
        ObjectInputStream inFromServer = new ObjectInputStream((clientSocket.getInputStream()));
        Answer answer = (Answer) inFromServer.readObject();
        protocole.traiter(answer);


        clientSocket.close();
    }
}