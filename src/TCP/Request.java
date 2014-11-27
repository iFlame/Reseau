package TCP;

import java.io.Serializable;

/**
 * Created by Quentin on 10/11/14.
 */
public class Request implements Serializable {

    private int serviceNumber;
    private String userName;
    private String userNickname;

/**
 * constructeur de requete
 * @param serviceNumber : numero de service 
 * @param userName : nom
 * @param userNickame : surnom
 */
    public Request(int serviceNumber, String userName, String userNickame) {
        this.serviceNumber = serviceNumber;
        this.userName = userName;
        this.userNickname = userNickame;
    }

/**
 * Permet d'obtenir le num�ro de service de la requete
 * @return le num�ro de service
 */
    public int getServiceNumber() {
        return serviceNumber;
    }
/**
 * permet d'obtenir le nom dans la requete
 * @return nom
 */
    public String getUserName() {
        return userName;
    }
/**
 * permet d'obtenir le surnom dans la requete
 * @return surnom
 */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * Cette methode redefinis le toString pour pouvoir passer de la sérialisation objet a la serialisation en String
     * plus facilement.
     * @return
     */
    public String toString() {
        if(serviceNumber == 10) {
            return "ajouterPersonne " + userName + " " +  userNickname;
        } else if(serviceNumber == 30) {
            return "afficher";
        } else {
            return "Requete non traitee.";
        }
    }

}
