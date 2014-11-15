package TCP;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Quentin on 15/11/2014.
 */
public class Client {

    private Socket clientSotcket;

    public Client(Socket clientSotcket) {
        this.clientSotcket = clientSotcket;
    }

    /**
     * Cette méthode permet l'ajout d'un nom avec un surnom non déjà présent dans la base de donnée.
     *
     * @param name
     * @param nickname
     * @return
     */
    public void addNameNickname(String name, String nickname) {
         sendRequest(new Request(10, name, nickname), clientSotcket);
    }

    /**
     * Cette méthode est une méthode privé permettant d'nevoyé les requètes à partir de la socket en paramètre.
     * @param request
     * @param clientSocket
     */
    private void sendRequest(Request request, Socket clientSocket) {
        ObjectOutputStream outToServer = null;
        try {
            outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            outToServer.writeObject(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
