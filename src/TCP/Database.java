package TCP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Database {
    HashMap<String, ArrayList<String>> database;

    public Database() {
        database = new HashMap<String, ArrayList<String>>();
    }

    /**
     * M�thode pour tester si un surnom est d�j� utilis� ou non.
     * A TESTER
     *
     * @param Nickname le surnom � tester
     * @return si le surnom est pr�sent ou non dans la database
     */
    public boolean isNicknameUse(String Nickname) {
        for (Entry<String, ArrayList<String>> entry : database.entrySet()) {
            for (String nick : entry.getValue()) {
                if (nick.compareTo(Nickname) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * M�thode pour r�cuperer le nom attribu� � un surnom.
     * A TESTER
     *
     * @param Nickname dont il faut trouver le nom
     * @return le nom associ�
     */
    public String nicknameName(String Nickname) {
        for (Entry<String, ArrayList<String>> entry : database.entrySet()) {
            for (String nick : entry.getValue()) {
                if (nick.compareTo(Nickname) == 0) {
                    return entry.getKey();
                }
            }
        }
        return "";
    }

    /**
     * M�thode pour tester si un nom est d�j� utilis� ou non.
     * A TESTER
     *
     * @param Nickname le nom � tester
     * @return si le nom est pr�sent ou non dans la database
     */
    public boolean isNameUse(String name) {
    	
        return database.containsKey(name);
    }

    /**
     * Methode permettant d'ajouter un nom � la database
     *
     * @param r la requete re�u par le serveur
     * @return la reponse � la requete
     */
    public Answer addName(Request r) {
        System.out.println(r.getUserName()+database.get(r.getUserName()));

        if (r.getUserNickname().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Ce surnom n�est pas disponible car d�j� utilis� :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (isNameUse(r.getUserName())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Ce nom n�est pas disponible car d�j� utilis� :" + r.getUserName() + ".", null);
            return new Answer(11, answer);
        } else {
            ArrayList<String> nickname = new ArrayList<String>();
            nickname.add(r.getUserNickname());
            database.put(r.getUserName(), nickname);
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        }
    }

    /**
     * Methode permettant d'ajouter un surnom � un nom d�j� dans la database
     *
     * @param r la requete re�u par le serveur
     * @return la reponse � la requete
     */
    public Answer addNickname(Request r) {
        if (r.getUserNickname().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Ce surnom n�est pas disponible car d�j� utilis� :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (!isNameUse(r.getUserName())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donn�e. L'ajout n�a pas �t� effectu�.", null);
            return new Answer(12, answer);
        } else {
            database.get(r.getUserName()).add(r.getUserNickname());
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        }
    }

    /**
     * Methode permettant d'ajouter un surnom � un nom d�j� pr�sent ou non dans la database
     *
     * @param r la requete re�u par le serveur
     * @return la reponse � la requete
     */
    public Answer addNickname2(Request r) {
        if (r.getUserNickname().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Ce surnom n�est pas disponible car d�j� utilis� :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (!isNameUse(r.getUserName())) {
            database.get(r.getUserName()).add(r.getUserNickname());
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        } else {
            ArrayList<String> nickname = new ArrayList<String>();
            nickname.add(r.getUserNickname());
            database.put(r.getUserName(), nickname);
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        }
    }

    /**
     * Methode permettant de supprimer un nom d�j� pr�sent dans la database
     *
     * @param r la requete re�u par le serveur
     * @return la reponse � la requete
     */
    public Answer removeName(Request r) {
        if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donn�e. La suppression n�a pas �t� effectu�e.", null);
            return new Answer(12, answer);
        } else {
            database.remove(r.getUserName());
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        }
    }

    /**
     * Methode permettant de supprimer un surnom � un nom d�j� pr�sent ou non dans la database
     *
     * @param r la requete re�u par le serveur
     * @return la reponse � la requete
     */
    public Answer removeNickname(Request r) {
        if (r.getUserNickname().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donn�e. La suppression n�a pas �t� effectu�e.", null);
            return new Answer(12, answer);
        } else if (!isNicknameUse(r.getUserNickname())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le surnom : " + r.getUserNickname() + " dans la base de donn�e. La suppression n�a pas �t� effectu�e.", null);
            return new Answer(12, answer);
        } else {
            database.get(r.getUserName()).remove(r.getUserNickname());
            return new Answer(20, new HashMap<String, ArrayList<String>>());
        }
    }

    public Answer printAll(Request r) {
        return new Answer(21, database);
    }

    public Answer printName(Request r) {
        if (r.getUserName().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donn�e. L'impression n�a pas �t� effectu�.", null);
            return new Answer(11, answer);
        }
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        answer.put(r.getUserName(), database.get(r.getUserName()));
        return new Answer(21, answer);
    }

    public Answer printNickname(Request r) {
        if (r.getUserNickname().compareTo("") == 0) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
            answer.put("Impossible de trouver le surnom : " + r.getUserNickname() + " dans la base de donn�e. L'impression n�a pas �t� effectu�.", null);
            return new Answer(11, answer);
        }
        //TODO
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        String name = nicknameName(r.getUserNickname());
        answer.put(name, database.get(name));
        return new Answer(21, answer);
    }

}