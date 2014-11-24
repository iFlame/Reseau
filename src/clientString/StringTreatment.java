package clientString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import TCP.Answer;

public class StringTreatment {
	public StringTreatment(){
		
	}
	
	public Answer traitmentAffichage(String affichage){
		StringTokenizer token=new StringTokenizer(affichage,".,");
		StringTokenizer tonek;
		String nom;
		ArrayList<String> surnom=new ArrayList();
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();

		while(token.hasMoreTokens()){
			tonek=new StringTokenizer(token.nextToken()," ");
			nom=tonek.nextToken();
			while(tonek.hasMoreTokens()){
				surnom.add(tonek.nextToken());
			}
			answer.put(nom, surnom);
		}
		return new Answer(21,answer);
	}
}
