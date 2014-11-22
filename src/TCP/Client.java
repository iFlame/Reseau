package TCP;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Quentin on 15/11/2014.
 */
public class Client implements ClientInterface {

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
    @Override
    public void addNameNickname(String name, String nickname) {
         sendRequest(new Request(10, name, nickname));
    }

    @Override
    public void printNameNickname() {
        sendRequest(new Request(30,null,null));
    }

    /**
     * Cette méthode est une méthode privé permettant d'nevoyé les requètes à partir de la socket en paramètre.
     * @param request
     */
    private void sendRequest(Request request) {
        ObjectOutputStream outToServer = null;
        try {
            outToServer = new ObjectOutputStream(clientSotcket.getOutputStream());
            outToServer.writeObject(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
