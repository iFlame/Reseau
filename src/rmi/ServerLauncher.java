package rmi;

/**
 * Created by Quentin on 01/12/2014.
 */
public class ServerLauncher {
    public static void main(String argc[]) {
        try{
            RMIServer s =new RMIServer();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
