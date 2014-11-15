package TCP; /**
 * Cette classe représente le client qui commmunique en TCP avec le serveur.
 * Ce client implémente l'interface ClientInterface obligatoire pour communiquer correctement.
 *
 * Created by Quentin Cornevin & Clement Audry.
 */

import graphic.ClientWindows;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient implements ClientInterface {


    public static void main(String argv[]) throws Exception {


        /** Déroulement du main :
         * - Demande nom client + port serveur
         * - demande request puis suite
         */
        boolean test = true;

        Socket clientSocket = new Socket("localhost", 6789); // Devra être remplacer par createClient

        Client client = new Client(clientSocket);
        ClientWindows clientWindows = new ClientWindows(client);

        Protocole protocole = new Protocole();
        Request request = new Request(10, "test", "test"); // Devra être remplacé par la boenne request.

        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        outToServer.writeObject(request);
        ObjectInputStream inFromServer = new ObjectInputStream((clientSocket.getInputStream()));
        Answer answer = (Answer) inFromServer.readObject();
        protocole.treat(answer);
 //       treatAnswer(inFromServer.readObject());
        while(test = true) {
            inFromServer = new ObjectInputStream((clientSocket.getInputStream()));
            answer = (Answer) inFromServer.readObject();
            protocole.treat(answer);
        }

        clientSocket.close();
    }

    /**
     * Cette méthode permet la création d'une socket sur le port passer en paramètre, avec un nom passer en paramètre.
     * Si un serveur répond pour ce numéro de port alors la connexion TCP est établie sinon la méthode renvoie une
     * exception.
     *
     * @param clientName
     * @param portNumber
     * @return
     * @throws java.io.IOException
     */
    public Socket createClient(String clientName, int portNumber) throws IOException {
        return new Socket(clientName, portNumber);
    }

    /**
     * Cette méthode permet l'ajout d'un nom avec un surnom non déjà présent dans la base de donnée.
     *
     * @param name
     * @param nickname
     * @return
     */
    public Request addNameNickname(String name, String nickname) {
        return new Request(10, name, nickname);
    }

    /**
     * Cette méthode permet de demander au serveur d'afficher les noms / surnoms.
     *
     * @return
     */
    public Request printNameNickname() {
        return new Request(30, null, null);
    }

/*
    public static void treatAnswer(Object objectReceived) {
        Answer answer = (Answer) objectReceived;
        Protocole protocole = new Protocole();
        protocole.treat(answer);
    }
*/
}