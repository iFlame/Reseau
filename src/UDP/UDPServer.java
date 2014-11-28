package UDP;

import TCP.Answer;
import TCP.Request;
import TCP.RequestTreatment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Quentin on 23/11/2014.
 */
public class UDPServer {
    public static void main(String args[]) throws Exception  {

        Request request;
        RequestTreatment requestTreatment = new RequestTreatment();
        DatagramSocket socket = new DatagramSocket(6789);
        ByteArrayInputStream baos;

        while(true) {
            /**
             * Lecture de la request du client :
             */
            byte[] recvBuf = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            socket.receive(receivePacket);
            InetAddress ipAdress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            baos = new ByteArrayInputStream(recvBuf);
            ObjectInputStream inFromServer = new ObjectInputStream(baos);
            request = (Request) inFromServer.readObject();
            System.out.println("Received: " + request.toString());
            Answer answer = requestTreatment.getInfo(request);

            /**
             * Envoie de la réponse au client :
             */
            ObjectOutputStream outToServer;
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream(2048);
            outToServer = new ObjectOutputStream(baos2);
            outToServer.flush();
            outToServer.writeObject(answer);
            outToServer.flush();
            byte[] Buf= baos2.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(Buf,Buf.length,ipAdress,port);
            socket.send(sendPacket);
        }
    }
}


