package Client;

import TCP.Request;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

/**
 * Created by Quentin on 23/11/2014.
 */
public class ObjectUDPClient extends VirtualClient {

    private DatagramSocket socket;
    public ObjectUDPClient(DatagramSocket socket) {
        this.socket = socket;
    }

    public void sendRequest(Request request) {
     ObjectOutputStream outToServer = null;
        try {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
            outToServer = new ObjectOutputStream(baos);
            outToServer.flush();
            outToServer.writeObject(request);
            outToServer.flush();
            byte[] Buf= baos.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(Buf,Buf.length, IPAddress, 6789);
            socket.send(sendPacket);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
