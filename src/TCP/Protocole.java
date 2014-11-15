package TCP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Cette classe permet le traitement des messages envoyé par le serveur après une l'envoie d'une Request par le client.
 * Il n'y qu'une seule méthode public nommé treat, qui fait appel à d'autre méthodes private pour traiter le message.
 * <p/>
 * Created by Quentin Cornevin & Clement Audry.
 */
public class Protocole {

    /**
     * Seul methode public de la classe qui permet de traiter les messages renvoyé par le serveur grace au paramètre
     * answer.
     *
     * @param answer
     */
    public void treat(Answer answer) {
        System.out.println("Answer Recu !");
        if (answer.getNumService() >= Constant.VALID_ANSWER) {
            validAnswer(answer.getTab());
        } else if (answer.getNumService() >= Constant.ERROR_ANSWER) {
            errorAnswer(answer.getTab().values());
        }
    }

    /**
     * Methode privée vérifiant les messages envoyés par le serveur après une requète valide.
     * Cette méthode recoit la hashMap, la transformer en collection puis on itère dessus pour afficher le tableau
     *
     * @param answer
     */
    private void validAnswer(HashMap<String, ArrayList<String>> answer) {
        Iterator it = answer.values().iterator();
        //System.out.println(answer.size());
        while (it.hasNext()) {
            System.out.println("caca");

            ArrayList<String> message = (ArrayList<String>) it.next();
            for (int i = 0; i < message.size(); i++) {
                System.out.println("Message du serveur : " + message.get(i));
            }
        }
    }

    /**
     * Méthode prvée vérifiant kes messages envoyés par le serveur après une requète non valide.
     *
     * @param message
     */
    private void errorAnswer(Collection<ArrayList<String>> message) {
        // TODO : Je pense y a moyen de tout mettre dans la meme méthode.
    }


}
