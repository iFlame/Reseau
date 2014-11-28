package clientString;

import Client.StringTCPClient;
import TCP.Answer;
import TCP.Protocole;
import graphic.ClientWindows;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class clientString {
    public static void main(String argv[]) throws Exception {

		StringTreatment stringTreatment=new StringTreatment();
		String modifiedSentence;
    	Socket clientSocket = new Socket("10.212.105.214", 8080);
		StringTCPClient stringTCPClient = new StringTCPClient(clientSocket);
		boolean test;
		Protocole protocole = new Protocole();
		ClientWindows clientWindows = new ClientWindows(stringTCPClient);
		protocole.ajouterObserver(clientWindows.getNameList());

		while(test = true) {
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			if(modifiedSentence.equals("fait")) {
				HashMap<String, ArrayList<String>> succesMap = new HashMap<String, ArrayList<String>>();
				succesMap.put("La requete s'est bien effectue", null);
				Answer serverAnswer = new Answer(20,succesMap);
				protocole.treat(serverAnswer);
			}
			else{
				Answer serverAnswer = stringTreatment.traitmentAffichage(modifiedSentence);
				protocole.treat(serverAnswer);
			}
		}
    	clientSocket.close();
    }
}
