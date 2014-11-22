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

public class TCPClient {

    public static void main(String argv[]) throws Exception {


        /** Déroulement du main :
         * - Demande nom client + port serveur
         * - demande request puis suite
         */
        boolean test = true;

        Socket clientSocket = new Socket("localhost", 6789); // Devra être remplacer par createClient

        Client client = new Client(clientSocket);
        ClientWindows clientWindows = new ClientWindows(client);
        ObjectInputStream inFromServer;
        Answer answer;
        Protocole protocole = new Protocole();
        protocole.ajouterObserver(clientWindows.getNameList());

        while(test = true) {
            inFromServer = new ObjectInputStream(clientSocket.getInputStream());
            answer = (Answer) inFromServer.readObject();
            protocole.treat(answer);
            System.out.println(answer.getNumService());
            
            System.out.println(answer.getTab().size());
        }

        clientSocket.close();
    }

}