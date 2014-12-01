package marshalling;


import protocole.Request;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Quentin on 15/11/2014.
 */
public class ObjectTCPClient extends VirtualClient {

    private Socket clientSotcket;

    public ObjectTCPClient(Socket clientSotcket) {
        super();
        this.clientSotcket = clientSotcket;
    }

    /**
     * Cette méthode est une méthode privé permettant d'nevoyé les requètes à partir de la socket en paramètre.
     * @param request
     */
    public void sendRequest(Request request) {
        ObjectOutputStream outToServer = null;
        try {
            outToServer = new ObjectOutputStream(clientSotcket.getOutputStream());
            outToServer.writeObject(request);
            if(request.getServiceNumber() == 50) {
                this.clientSotcket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
