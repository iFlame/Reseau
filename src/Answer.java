import java.io.Serializable;
import java.util.HashMap;
public class Answer implements Serializable {

    private int numService;
	private HashMap<String,String[]> tab;
	
	public Answer(){
		tab=new HashMap<String,String[]>();
		
	}
	public Answer(int i, HashMap<String,String[]> tab ){
		this.tab=tab;
		this.numService=i;
		
	}

    public String toString() {
        return "Answer";
    }

    public int getNumService() {
        return numService;
    }

    public void setNumService(int numService) {
        this.numService = numService;
    }

    public HashMap<String, String[]> getTab() {
        return tab;
    }

    public void setTab(HashMap<String, String[]> tab) {
        this.tab = tab;
    }
}
