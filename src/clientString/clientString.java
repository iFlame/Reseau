package clientString;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.Socket;

public class clientString {
    public static void main(String argv[]) throws Exception {
		String sentence;
		String modifiedSentence;
    	Socket clientSocket = new Socket("10.212.119.194", 8080);
    	BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
    	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
    	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    	  sentence = inFromUser.readLine();
    	  outToServer.writeBytes(sentence + '\n');
    	  modifiedSentence = inFromServer.readLine();
    	System.out.println("FROM SERVER: " + modifiedSentence);
    	clientSocket.close();
    }
}
