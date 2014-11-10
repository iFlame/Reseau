import java.io.Serializable;
import java.util.HashMap;
public class Answer implements Serializable {

	private int serviceNumber;
	private HashMap<String,String[]> userInfo;
	
	public Answer(){
		userInfo=new HashMap<String,String[]>();
		
	}
	public Answer(int i, HashMap<String,String[]> tab ){
		this.userInfo=userInfo;
		this.serviceNumber=i;		
	}

    public String toString() {
        return "Answer";
    }
	public int getServiceNumber(){
		return serviceNumber;
	}
	public HashMap<String,String[]> getUserInfo(){
		return userInfo;
	}

}
