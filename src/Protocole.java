import java.util.Collection;
import java.util.HashMap;

/**
 * Cette classe permet le traitement des messages envoyé par le serveur après une l'envoie d'une Request par le client.
 * Il n'y qu'une seule méthode public nommé treat, qui fait appel à d'autre méthodes private pour traiter le message.
 *
 * Created by Quentin Cornevin & Clement Audry.
 */
public class Protocole {

    /**
     * Seul methode public de la classe qui permet de traiter les messages renvoyé par le serveur grace au paramètre
     * answer.
     * @param answer
     */
    public void treat(Answer answer) {
        System.out.println("Answer Recu !");
        if(answer.getNumService() >= Constant.VALID_ANSWER) {
            validAnswer(answer.getTab());
        } else if (answer.getNumService()>= Constant.ERROR_ANSWER ) {
            errorAnswer(answer.getTab().values());
        }
    }

    /**
     * Methode privée vérifiant les messages envoyés par le serveur après une requète valide.
     * @param answer
     */
    private void validAnswer(HashMap<String, String[]> answer) {
        //TODO:
    }

    /**
     * Méthode prvée vérifiant kes messages envoyés par le serveur après une requète non valide.
     * @param message
     */
    private void errorAnswer(Collection<String[]> message) {
        //TODO:
    }


}
