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
     * Mï¿½thode pour tester si un surnom est dï¿½jï¿½ utilisï¿½ ou non.
     * A TESTER
     *
     * @param Nickname le surnom ï¿½ tester
     * @return si le surnom est prï¿½sent ou non dans la database
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
     * Mï¿½thode pour rï¿½cuperer le nom attribuï¿½ ï¿½ un surnom.
     * A TESTER
     *
     * @param Nickname dont il faut trouver le nom
     * @return le nom associï¿½
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
     * Mï¿½thode pour tester si un nom est dï¿½jï¿½ utilisï¿½ ou non.
     * A TESTER
     *
     * @param Nickname le nom ï¿½ tester
     * @return si le nom est prï¿½sent ou non dans la database
     */
    public boolean isNameUse(String name) {
    	
        return database.containsKey(name);
    }

    /**
     * Methode permettant d'ajouter un nom ï¿½ la database
     *
     * @param r la requete reï¿½u par le serveur
     * @return la reponse ï¿½ la requete
     */
    public Answer addName(Request r) {
        System.out.println(r.getUserName()+database.get(r.getUserName()));
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();

        if (r.getUserNickname().compareTo("") == 0) {
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            answer.put("Ce surnom nï¿½est pas disponible car dï¿½jï¿½ utilisï¿½ :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (isNameUse(r.getUserName())) {
            answer.put("Ce nom nï¿½est pas disponible car dï¿½jï¿½ utilisï¿½ :" + r.getUserName() + ".", null);
            return new Answer(11, answer);
        } else {
            ArrayList<String> nickname = new ArrayList<String>();
            nickname.add(r.getUserNickname());
            database.put(r.getUserName(), nickname);
            answer.put("La requète c'est bien effectuée",null);
            return new Answer(20, answer);
        }
    }

    /**
     * Methode permettant d'ajouter un surnom ï¿½ un nom dï¿½jï¿½ dans la database
     *
     * @param r la requete reï¿½u par le serveur
     * @return la reponse ï¿½ la requete
     */
    public Answer addNickname(Request r) {
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        if (r.getUserNickname().compareTo("") == 0) {
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            answer.put("Ce surnom nï¿½est pas disponible car dï¿½jï¿½ utilisï¿½ :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (!isNameUse(r.getUserName())) {
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donnï¿½e. L'ajout nï¿½a pas ï¿½tï¿½ effectuï¿½.", null);
            return new Answer(12, answer);
        } else {
            database.get(r.getUserName()).add(r.getUserNickname());
            answer.put("La requète c'est bien effectuée",null);
            return new Answer(20, answer);
        }
    }

    /**
     * Methode permettant d'ajouter un surnom ï¿½ un nom dï¿½jï¿½ prï¿½sent ou non dans la database
     *
     * @param r la requete reï¿½u par le serveur
     * @return la reponse ï¿½ la requete
     */
    public Answer addNickname2(Request r) {
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        if (r.getUserNickname().compareTo("") == 0) {
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            answer.put("Ce surnom nï¿½est pas disponible car dï¿½jï¿½ utilisï¿½ :" + r.getUserNickname() + ".", null);
            return new Answer(11, answer);
        } else if (!isNameUse(r.getUserName())) {
            answer.put("La requète c'est bien effectuée",null);
            database.get(r.getUserName()).add(r.getUserNickname());
            return new Answer(20,answer);
        } else {
            ArrayList<String> nickname = new ArrayList<String>();
            nickname.add(r.getUserNickname());
            database.put(r.getUserName(), nickname);
            answer.put("La requète c'est bien effectuée",null);
            return new Answer(20, answer);
        }
    }

    /**
     * Methode permettant de supprimer un nom dï¿½jï¿½ prï¿½sent dans la database
     *
     * @param r la requete reï¿½u par le serveur
     * @return la reponse ï¿½ la requete
     */
    public Answer removeName(Request r) {
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donnï¿½e. La suppression nï¿½a pas ï¿½tï¿½ effectuï¿½e.", null);
            return new Answer(12, answer);
        } else {
            answer.put("La requète c'est bien effectuée",null);
            database.remove(r.getUserName());
            return new Answer(20, answer);
        }
    }

    /**
     * Methode permettant de supprimer un surnom ï¿½ un nom dï¿½jï¿½ prï¿½sent ou non dans la database
     *
     * @param r la requete reï¿½u par le serveur
     * @return la reponse ï¿½ la requete
     */
    public Answer removeNickname(Request r) {
    	HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();    	
        if (r.getUserNickname().compareTo("") == 0) {
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donnï¿½e. La suppression nï¿½a pas ï¿½tï¿½ effectuï¿½e.", null);
            return new Answer(12, answer);
        } else if (!isNicknameUse(r.getUserNickname())) {
            answer.put("Impossible de trouver le surnom : " + r.getUserNickname() + " dans la base de donnï¿½e. La suppression nï¿½a pas ï¿½tï¿½ effectuï¿½e.", null);
            return new Answer(12, answer);
        } else {
            answer.put("La requète c'est bien effectuée",null);
            database.get(r.getUserName()).remove(r.getUserNickname());
            return new Answer(20, answer);
        }
    }

    public Answer printAll(Request r) {
        return new Answer(21, database);
    }

    public Answer printName(Request r) {
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        if (r.getUserName().compareTo("") == 0) {
            answer.put("Nom invalide.", null);
            return new Answer(10, answer);
        } else if (!isNameUse(r.getUserName())) {
            answer.put("Impossible de trouver le nom : " + r.getUserName() + " dans la base de donnï¿½e. L'impression nï¿½a pas ï¿½tï¿½ effectuï¿½.", null);
            return new Answer(11, answer);
        }
        answer.put(r.getUserName(), database.get(r.getUserName()));
        return new Answer(21, answer);
    }

    public Answer printNickname(Request r) {
        HashMap<String, ArrayList<String>> answer = new HashMap<String, ArrayList<String>>();
        if (r.getUserNickname().compareTo("") == 0) {
            answer.put("Surnom invalide.", null);
            return new Answer(10, answer);
        } else if (isNicknameUse(r.getUserNickname())) {
            answer.put("Impossible de trouver le surnom : " + r.getUserNickname() + " dans la base de donnï¿½e. L'impression nï¿½a pas ï¿½tï¿½ effectuï¿½.", null);
            return new Answer(11, answer);
        }
        String name = nicknameName(r.getUserNickname());
        answer.put(name, database.get(name));
        return new Answer(21, answer);
    }

}