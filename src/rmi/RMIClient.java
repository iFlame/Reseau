package rmi;

import graphic.ClientWindows;
import marshalling.VirtualClient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Quentin on 01/12/2014.
 */
public class RMIClient {


    static public void main(String args[]) {
        Operation rmiServer;
        Registry registry = null;
        String serverAddress = "localhost";
        String serverPort = "3232";
        String text = "coucou";
        System.out.println("sending " + text + " to " + serverAddress + ":" + serverPort);
        try {
            try {
                registry = LocateRegistry.getRegistry(
                        serverAddress,
                        (new Integer(serverPort)).intValue()
                );
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            rmiServer =
                    (Operation) (registry.lookup("rmiServer"));

            marshalling.RMIClient rmiClient = new marshalling.RMIClient(rmiServer,null);
            ClientWindows clientWindows = new ClientWindows(rmiClient);
            rmiClient.setWindows(clientWindows);


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
