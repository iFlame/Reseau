package UDP;

import Client.ObjectUDPClient;
import TCP.Answer;
import TCP.Protocole;
import graphic.ClientWindows;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Quentin on 23/11/2014.
 */
public class UDPClient {
    public static void main(String args[]) throws Exception    {
        /*
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);
        clientSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
        clientSocket.close();
        */

        boolean test = true;
        DatagramSocket clientSocket = new DatagramSocket();
        ObjectUDPClient objectUDPClient = new ObjectUDPClient(clientSocket);
        ClientWindows clientWindows = new ClientWindows(objectUDPClient);
        Answer answer;
        Protocole protocole = new Protocole();
        protocole.ajouterObserver(clientWindows.getNameList());

        while(test = true) {
            byte[] recvBuf = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            clientSocket.receive(receivePacket);

            ByteArrayInputStream baos = new ByteArrayInputStream(recvBuf);
            ObjectInputStream inFromServer = new ObjectInputStream(baos);
            answer = (Answer) inFromServer.readObject();
            protocole.treat(answer);
            //  System.out.println(answer.getNumService());

            //  System.out.println(answer.getTab().size());
        }

        clientSocket.close();

    }
}


