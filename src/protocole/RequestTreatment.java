package protocole;

public class RequestTreatment {
    Database database;

    public RequestTreatment() {
        database = new Database();
    }

    /**
     * M�thode permetant d'obtenir le type de requ�te. Si on cr�e une nouvelle requete il faudra modifier
     * cette m�thode
     *
     * @param r la requete � analyser
     */
    public Answer getInfo(Request r) {
        int i = r.getServiceNumber() / 10;
        switch (i) {
            case 1:
                return getTypeAdd(r);
            case 2:
                return getTypeRemove(r);
            case 3:
                return getTypePrint(r);
            case 4:
                getTypeChange(r);
                return null;
            case 5:
                getTypeChange(r);
                return new Answer(30, null);
            default:
                return null;
        }
    }

    /**
     * M�thode permetant d'obtenir le type d'ajout de la requ�te. Si on cr�e une nouvelle requete il faudra modifier
     * cette m�thode
     *
     * @param r la requete � analyser
     */
    private Answer getTypeAdd(Request r) {
        int i = r.getServiceNumber();
        switch (i) {
            case 10:
                return database.addName(r);
            case 11:
                return database.addNickname(r);
            case 12:
                return database.addNickname2(r);
            default:
                return null;
        }
    }

    /**
     * M�thode permetant d'obtenir le type de suppression de la requ�te. Si on cr�e une nouvelle requete il faudra modifier
     * cette m�thode
     *
     * @param r la requete � analyser
     */
    private Answer getTypeRemove(Request r) {
        int i = r.getServiceNumber();
        switch (i) {
            case 20:
                return database.removeName(r);
            case 21:
                return database.removeNickname(r);
            default:
                return null;
        }
    }

    /**
     * M�thode permetant d'obtenir le type d'affichage de la requ�te. Si on cr�e une nouvelle requete il faudra modifier
     * cette m�thode
     *
     * @param r la requete � analyser
     */
    private Answer getTypePrint(Request r) {
        int i = r.getServiceNumber();
        switch (i) {
            case 30:
                return database.printAll(r);
            case 31:
                return database.printName(r);
            case 32:
                return database.printNickname(r);
            default:
                return null;
        }
    }

    /**
     * M�thode permetant d'obtenir le type de modification de la requ�te. Si on cr�e une nouvelle requete il faudra modifier
     * cette m�thode
     *
     * @param r la requete � analyser
     */
    private void getTypeChange(Request r) {
        int i = r.getServiceNumber();
        switch (i) {
            case 40:
                break;
        }
    }

}
