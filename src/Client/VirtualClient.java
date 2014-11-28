package Client;

import TCP.Request;

/**
 * Created by Quentin on 23/11/2014.
 */
public abstract class VirtualClient {

    /**
     * Cette méthode permet l'ajout d'un nom avec un surnom non déjà présent dans la base de donnée.
     *
     * @param name
     * @param nickname
     * @return
     */
    public void addNameNickname(String name, String nickname) {
        sendRequest(new Request(10, name, nickname));
    }

    /**
     * Cette méthode permet d'envoyer au serveur une deconnexion.
     */
    public void disconnect() {
        sendRequest(new Request(50,null,null));
    }

    public void printNameNickname() {
        sendRequest(new Request(30,null,null));
    }

    public void sendRequest(Request request) {}
}
