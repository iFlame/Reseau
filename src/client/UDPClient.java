package client;

import marshalling.ObjectUDPClient;
import protocole.Answer;
import protocole.Protocole;
import graphic.ClientWindows;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Quentin on 23/11/2014.
 */
public class UDPClient {
    public static void main(String args[]) throws Exception {

        boolean test = true;
        DatagramSocket clientSocket = new DatagramSocket();
        ObjectUDPClient objectUDPClient = new ObjectUDPClient(clientSocket);
        ClientWindows clientWindows = new ClientWindows(objectUDPClient);
        Answer answer;
        Protocole protocole = new Protocole();
        protocole.ajouterObserver(clientWindows.getNameList());
        while (test) {
            byte[] recvBuf = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            clientSocket.receive(receivePacket);
            ByteArrayInputStream baos = new ByteArrayInputStream(recvBuf);
            ObjectInputStream inFromServer = new ObjectInputStream(baos);
            answer = (Answer) inFromServer.readObject();
            System.out.println("traitement de la answer");
            protocole.treat(answer);
        }
        clientSocket.close();
    }
}


