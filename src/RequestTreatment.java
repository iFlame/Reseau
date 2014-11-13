public class RequestTreatment {
	Database database;
	public RequestTreatment(){
		database = new Database();
	}
	
	/**
	 * Méthode permetant d'obtenir le type de requête. Si on crée une nouvelle requete il faudra modifier
	 * cette méthode
	 * @param r la requete à analyser
	 */
	public Answer getInfo(Request r){
		int i =r.getServiceNumber()/10;
		switch (i){
		case 1 :
			return getTypeAdd(r);
		case 2 :
			return getTypeRemove(r);
		case 3 :
			return getTypePrint(r);
		case 4 :
			getTypeChange(r);
			return null;
		default : 
			return null;
		}
	}
	/**
	 * Méthode permetant d'obtenir le type d'ajout de la requête. Si on crée une nouvelle requete il faudra modifier
	 * cette méthode
	 * @param r la requete à analyser
	 */
	private Answer getTypeAdd(Request r) {
		int i =r.getServiceNumber();
		switch (i){
		case 10 :
			return database.addName(r);
		case 11 :
			return database.addNickname(r);
		case 12 :
			return database.addNickname2(r);
		default : 
			return null;
		}
	}

	/**
	 * Méthode permetant d'obtenir le type de suppression de la requête. Si on crée une nouvelle requete il faudra modifier
	 * cette méthode
	 * @param r la requete à analyser
	 */
	private Answer getTypeRemove(Request r) {
		int i =r.getServiceNumber();
		switch (i){
		case 20 :
			return database.removeName(r);
		case 21 :
			return database.removeNickname(r);
		default : 
			return null;
		}
	}
	
	/**
	 * Méthode permetant d'obtenir le type d'affichage de la requête. Si on crée une nouvelle requete il faudra modifier
	 * cette méthode
	 * @param r la requete à analyser
	 */
	private Answer getTypePrint(Request r) {
		int i =r.getServiceNumber();
		switch (i){
		case 30 :
			return database.printAll(r);
		case 31 :
			return database.printName(r);
		case 32 :
			return database.printNickname(r);
		default : 
			return null;
		}
	}
	/**
	 * Méthode permetant d'obtenir le type de modification de la requête. Si on crée une nouvelle requete il faudra modifier
	 * cette méthode
	 * @param r la requete à analyser
	 */
	private void getTypeChange(Request r) {
		int i =r.getServiceNumber();
		switch (i){
		case 40 :
			break;
		}
	}

}
