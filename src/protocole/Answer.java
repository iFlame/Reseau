package protocole;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Answer implements Serializable {

    private int numService;
    private HashMap<String, ArrayList<String>> tab;

    /**
     * Cr�e un objet par defaut
     *
     */
    public Answer() {
        tab = new HashMap<String, ArrayList<String>>();

    }
/**
 * Cr�e un objet Answer
 * @param i numero de service
 * @param tab Arraylist de la r�ponse
 */
    public Answer(int i, HashMap<String, ArrayList<String>> tab) {
        this.tab = tab;
        this.numService = i;
    }
/**
 * to string
 */
    public String toString() {
        return "Answer";
    }
/**
 * donne acces au num�ro de service de l'answer
 * @return numero de service
 */
    public int getNumService() {
        return numService;
    }
/**
 * modifie le num�ro de service
 * @param numService
 */
    public void setNumService(int numService) {
        this.numService = numService;
    }
/**
 * donne acc�s � la hashmap de answer
 * @return la hashmap
 */
    public HashMap<String, ArrayList<String>> getTab() {
        return tab;
    }
/**
 * Permet de modifier la hashmap
 *  * @param tab
 */
    public void setTab(HashMap<String, ArrayList<String>> tab) {
        this.tab = tab;
    }
}
