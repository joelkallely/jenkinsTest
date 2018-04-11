

import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.runner.JUnitCore;

class OptionPaneExample extends WindowAdapter{  
	JFrame f;  
	OptionPaneExample() throws IOException{  
	    f=new JFrame();   
	    f.addWindowListener(this);  
	    int a=JOptionPane.showConfirmDialog(f,"elements folder should be placed in this directory.\ndata.en.properties and the language to be compared should be placed in the languages folder.\n");
	    if(a==JOptionPane.YES_OPTION){  
	    	try {
//	    		App.execExtraction();
//	    		JUnitCore.main(
//	    		         "RunTest");
	    		JUnitCore junit = new JUnitCore();
	    		junit.run(RunTest.class);
	    	}
	    	catch(Exception e){
	    		JOptionPane.showMessageDialog(null, e.toString()+"\nPlease Try Again", "ERROR ", JOptionPane.INFORMATION_MESSAGE);
	    	}
	    	finally {
	    		System.exit(0);
	    	}
//		      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    else if(a==JOptionPane.CANCEL_OPTION) {
	    	System.out.println("cancel button");
	    	System.exit(0);
	    }
	    else if(a==JOptionPane.NO_OPTION) {
	    	System.exit(0);
	    }
	}  

}

public class RunClass 
{
	public static List<String> filesToCheck = new LinkedList<String>();
	public static List<String> htmlFiles = new LinkedList<String>();
	public static List<String> languageFiles = new LinkedList<String>();
	public static List<String> directoriesToNavigate = new LinkedList<String>();
    public static void main( String[] args ) throws IOException
    {    	
			OptionPaneExample panel = new OptionPaneExample();
    }


}
