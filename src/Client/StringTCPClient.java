package Client;

import TCP.Request;

import java.io.DataOutputStream;
import java.io.IOException;
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
            outToServer.writeBytes(sentence);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
