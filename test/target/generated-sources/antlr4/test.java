import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
    public class test 
    {
    	public static ArrayList<String> factsAndRules = new ArrayList<String>();
    	public static String inputPath = "Input/P.cdl";
    	
    	public ArrayList<String>  getFactsAndRules(){
    		   return factsAndRules;
    	   }
    	
    	public static void main( String[] args) throws Exception 
    	{
    		PrintStream out = new PrintStream(new FileOutputStream("Input/output.txt"));
    		   System.setOut(out);
    		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputPath));
    		
    		DatalogLexer lexer = new DatalogLexer(input);
    		lexer.removeErrorListeners();
    		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
    		CommonTokenStream tokens = new CommonTokenStream(lexer);
    		
    		DatalogParser parser = new DatalogParser(tokens);
    		parser.removeErrorListeners();
    		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
    		
    		ParseTree tree = parser.datalogProgram(); // begin parsing at rule 'r'
    		
    		test.readInputFile();
    		
    		for(String delete : factsAndRules)
    			System.out.println(delete);
    	}
    	
    	public static void readInputFile()
    	{
    		rule re=new rule();
    		fact fe=new fact();
    		try {
    			BufferedReader br = new BufferedReader(new FileReader(inputPath));
				String line;
				int i =0;

				ArrayList<Integer> list=new ArrayList<Integer>();
	    		list = ThrowingErrorListener.getLineNumbers();
	    		list = (ArrayList<Integer>) list.stream().distinct().collect(Collectors.toList());
	    		System.out.println(list.size());
	    		if(list.size() == 0)
	    			list.add(-1);

	    		while((line = br.readLine()) != null)
				{
					i++;
					if(list.contains(i));
					else{
						if(line.contains(":")){
							re.read(line);
						}
						else{
							fe.read(line);
						}
						}
				}
	    		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }