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

    public String toString() {
        return "requete recut";
    }
/**
 * Permet d'obtenir le numéro de service de la requete
 * @return le numéro de service
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
}
