
public class RequestTreatment {
	public RequestTreatment(){
	}
	
	/**
	 * M�thode permetant d'obtenir le type de requ�te. Si on cr�e une nouvelle requete il faudra modifier
	 * cette m�thode
	 * @param r la requete � analyser
	 */
	public void getInfo(Request r){
		int i =r.getServiceNumber()/10;
		switch (i){
		case 1 :
			getTypeAdd(r);
			break;
		case 2 :
			getTypeRemove(r);
			break;
		case 3 :
			getTypePrint(r);
			break;
		case 4 :
			getTypeChange(r);
			break;
		}
	}

	private void getTypeChange(Request r) {
		// TODO Auto-generated method stub
		
	}

	private void getTypePrint(Request r) {
		// TODO Auto-generated method stub
		
	}

	private void getTypeRemove(Request r) {
		// TODO Auto-generated method stub
		
	}

	private void getTypeAdd(Request r) {
		// TODO Auto-generated method stub
		
	}
}
