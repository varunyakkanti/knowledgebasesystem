import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bloop {

	private	Map<String, Integer> EDBPredicates = new HashMap<String, Integer>();
	private ArrayList<String> IDBPredicates = new ArrayList<String>();
	
	
	public Map<String, Integer> getEDBPredicates() {
		return EDBPredicates;
	}


	public void setEDBPredicates(String eDBPredicates, int distance) {
		EDBPredicates.put(eDBPredicates, distance);
	}


	public ArrayList<String> getIDBPredicates() {
		return IDBPredicates;
	}


	public void setIDBPredicates(String iDBPredicates) {
		IDBPredicates.add(iDBPredicates);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bloop b = new bloop();
		b.setIDBPredicates("answer");
		b.setEDBPredicates("parent",1);
		b.setEDBPredicates("ancestor",2);
		b.setEDBPredicates("mother",0);
		
	}

}
