package TCP;

import java.io.Serializable;

/**
 * Created by Quentin on 10/11/14.
 */
public class Request implements Serializable {

    private int serviceNumber;
    private String userName;
    private String userNickname;


    public Request(int serviceNumber, String userName, String userNickame) {
        this.serviceNumber = serviceNumber;
        this.userName = userName;
        this.userNickname = userNickame;
    }

    public String toString() {
        return "requete recut";
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNickname() {
        return userNickname;
    }
}
