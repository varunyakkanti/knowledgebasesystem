

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class fact {
	
	public static Map<String, listfor> facts;
	public fact()
	{
	facts = new HashMap<String, listfor>();
	
	}
	public void read(String fact) throws Exception
	{
		
		
		
			String a=fact.substring(fact.indexOf("(")+1,fact.indexOf(")")-1);
			String[] tokens=a.split(",");
			String factname=fact.substring(0, fact.indexOf("("));
			
			if(facts.get(factname+tokens.length)==null){
				System.out.println(factname+tokens.length);
				
			facts.put(factname+tokens.length, new listfor(tokens));
			}
			else{
			if(facts.get(factname+tokens.length)!=null){
				
				listfor obj=facts.get(factname);
				obj.add(tokens);
				
								}
				}
			
		
			
	}

}