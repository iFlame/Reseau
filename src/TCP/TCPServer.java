package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class TCPServer {

    public static void main(String argv[]) throws Exception {

        ServerSocket welcomeSocket = null;
        boolean listening = true;

        try {
            welcomeSocket = new ServerSocket(6789);

        } catch (IOException e) {
            System.out.println("Port 6789 non disponible.");
        }
        while(listening) {
            new MultiServerThread(welcomeSocket.accept()).start();
        }
        welcomeSocket.close();
    }
}