

import java.util.ArrayList;

public class listfor {
	ArrayList<String[]>a=new ArrayList<String[]>();
	public listfor(String[] factname){
		a.add(factname);
	}
	public void add(String[] factname){
	a.add(factname);
		
	}
	public ArrayList<String[]> getlist(){
		return a;
		
	}

}
