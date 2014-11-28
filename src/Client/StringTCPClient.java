package Client;

import TCP.Request;

import java.io.*;
import java.net.Socket;

/**
 * Created by Quentin on 23/11/2014.
 */
public class StringTCPClient extends VirtualClient {

    private Socket socket;

    public StringTCPClient(Socket socket) {
        super();
        this.socket = socket;
    }

    public void sendRequest(Request request) {
        String sentence;
        try {
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            sentence = request.toString();
            System.out.println(sentence);
            outToServer.writeBytes(sentence + '\n');
            if(request.getServiceNumber() == 50) {
                this.socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
