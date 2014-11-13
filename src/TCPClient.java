/**
 * Cette classe représente le client qui commmunique en TCP avec le serveur.
 * Ce client implémente l'interface ClientInterface obligatoire pour communiquer correctement.
 *
 * Created by Quentin Cornevin & Clement Audry.
 */
import java.io.*;
import java.net.*;

public class TCPClient implements ClientInterface{

    /**
     * Cette méthode permet la création d'une socket sur le port passer en paramètre, avec un nom passer en paramètre.
     * Si un serveur répond pour ce numéro de port alors la connexion TCP est établie sinon la méthode renvoie une
     * exception.
     * @param clientName
     * @param portNumber
     * @return
     * @throws IOException
     */
    public Socket createClient(String clientName, int portNumber) throws IOException {
        return new Socket(clientName,portNumber);
    }

    /**
     * Cette méthode permet l'ajout d'un nom avec un surnom non déjà présent dans la base de donnée.
     * @param name
     * @param nickname
     * @return
     */
    public Request addNameNickname(String name, String nickname) {
        return new Request(10,name, nickname);
    }

    /**
     * Cette méthode permet de demander au serveur d'afficher les noms / surnoms.
     * @return
     */
    public Request printNameNickname() {
        return new Request(30, null,null);
    }

    public static void main(String argv[]) throws Exception  {




        Socket clientSocket = new Socket("localhost", 6789);
        Protocole protocole = new Protocole();
        Request request = new Request(10,"test", "test");

        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        outToServer.writeObject(request);
        ObjectInputStream inFromServer = new ObjectInputStream((clientSocket.getInputStream()));
        Answer answer = (Answer) inFromServer.readObject();
        protocole.treat(answer);


        clientSocket.close();
    }




}