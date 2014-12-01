package server;

import java.io.IOException;
import java.net.ServerSocket;

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