import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ThrowingErrorListener extends BaseErrorListener {
public static ArrayList<Integer> lineNumbers = new ArrayList<>();
   public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();
   
   
   @Override
   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
      throws ParseCancellationException 
   {
	  	   if(charPositionInLine==0&&(msg.contains("missing '.' at")||msg.contains("expecting '.'"))){
		   System.out.println("line " +(line-1 )+ ":" + charPositionInLine + " " + msg);
		   lineNumbers.add(line-1);
	   }
	   else{
	   try 
	   {
		   System.out.println("line " + line + ":" + charPositionInLine + " " + msg);
		   lineNumbers.add(line);
	   } catch (Exception e1) {
		   // TODO Auto-generated catch block
		   e1.printStackTrace();
	   } 
     }
   }
   
   	public static ArrayList<Integer>  getLineNumbers(){
	   return lineNumbers;
   }
}