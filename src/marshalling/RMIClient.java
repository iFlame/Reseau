package marshalling;

import graphic.ClientWindows;
import marshalling.VirtualClient;
import protocole.Answer;
import protocole.Protocole;
import protocole.Request;
import rmi.Operation;

import java.rmi.RemoteException;

/**
 * Created by Quentin on 01/12/2014.
 */
public class RMIClient extends VirtualClient {

    private Operation operation;
    private Protocole protocole;
    private ClientWindows windows;

    public RMIClient(Operation operation, ClientWindows clientWindows) {
        this.operation = operation;
        this.protocole = new Protocole();
        this.windows = clientWindows;
    }

    public void sendRequest(Request request) {
        try {
            Answer aswer = operation.treatRequest(request);
            protocole.treat(aswer);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setWindows(ClientWindows clientWindows) {
        this.windows = clientWindows;
        protocole.ajouterObserver(windows.getNameList());
    }
}
