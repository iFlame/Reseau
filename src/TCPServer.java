import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class TCPServer {

    public static void main(String argv[]) throws Exception {

        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            RequestTreatment rt = new RequestTreatment();
            Socket connectionSocket = welcomeSocket.accept();
            ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
            Request request = (Request) inFromClient.readObject();
            ObjectOutputStream outFromClient = new ObjectOutputStream((connectionSocket.getOutputStream()));

            // Test pour check mon client :
            ArrayList<String> table = new ArrayList<String>();
            table.add("YO");
            HashMap<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
            hashmap.put("ClemTCon", table);

            Answer answer = new Answer(20, hashmap);

            //Answer answer = new Answer();
            outFromClient.writeObject(answer);
            System.out.println("Received: " + request.toString());
        }
    }

}