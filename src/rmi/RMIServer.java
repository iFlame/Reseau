package rmi;

import protocole.Answer;
import protocole.Protocole;
import protocole.Request;
import protocole.RequestTreatment;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Quentin on 01/12/2014.
 */
public class RMIServer extends UnicastRemoteObject implements Operation{

    int      thisPort;
    String   thisAddress;
    Registry registry;
    RequestTreatment requestTreatment;
    Protocole protocole;

    protected RMIServer() throws RemoteException {
        thisPort=3232;
        requestTreatment = new RequestTreatment();
        protocole = new Protocole();
        try{
            thisAddress= (InetAddress.getLocalHost()).toString();
        }
        catch(Exception e){
            throw new RemoteException("can't get inet address.");
        }

        System.out.println("this address="+thisAddress+",port="+thisPort);

        try{
            registry = LocateRegistry.createRegistry(thisPort);
            registry.rebind("rmiServer", this);
        }
        catch(RemoteException e){
            throw e;
        }
    }

    @Override
    public Answer treatRequest(Request request) {
        return requestTreatment.getInfo(request);
    }
}
