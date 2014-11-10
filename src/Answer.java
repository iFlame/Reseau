import java.util.HashMap;
public class Answer {
	private int numService;
	private HashMap<String,String[]> tab;
	
	public Answer(){
		tab=new HashMap<String,String[]>();
		
	}
	public Answer(int i, HashMap<String,String[]> tab ){
		this.tab=tab;
		this.numService=i;
		
	}
}
