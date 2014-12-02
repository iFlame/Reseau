package rmi;

import protocole.Answer;
import protocole.Request;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Quentin on 01/12/2014.
 */
public interface Operation extends Remote {

    Answer treatRequest(Request request) throws RemoteException;

}
