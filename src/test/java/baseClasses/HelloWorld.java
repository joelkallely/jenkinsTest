package baseClasses;
import com.jcraft.jsch.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class HelloWorld {

	
	 
	static Sheet sh = null;
	static JSch jsch=new JSch();
	static String host="root@192.168.150.47";
	static Session session = null;
	static Channel channel= null;
	public static void main(String arg[]) throws Exception
	{

		
//String location = "http://env24-node3.flytxt.com:5051/files/download?path=%2Fvar%2Flib%2Fmesos%2Fslaves%2Ffbf6e921-f495-4de8-b6f1-07cb2f0ed876-S3%2Fframeworks%2F9d14cc2d-6bf0-43e0-9c67-494a1c12816f-0000%2Fexecutors%2Fneon_apps_platform_conveyor-belt.df9f4179-c5e8-11e7-bbb7-2a7ea17b5978%2Fruns%2Fa29adc80-6af1-4c1d-afea-6501eee63915%2Fstdout";
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/div/table/tbody/tr[3]/td[7]/span[2]/a/../../../td[8]/a"))).getAttribute("href");
//char[] node = new char[5];
//char[] loc = new char[1000];
//location.getChars(17, 18, node, 0);
//location = location.replaceAll("(%2F)", "/");
//String logfile[] = location.split("=");
//int len = logfile[1].length();
//logfile[1].getChars(0, len-6, loc, 0);
//System.out.println(location);
//System.out.println(node);
//System.out.println(loc);
init();
		//executeCommand("cd /var/lib/mesos/slaves/fbf6e921-f495-4de8-b6f1-07cb2f0ed876-S3/frameworks/9d14cc2d-6bf0-43e0-9c67-494a1c12816f-0000/executors/neon_apps_platform_conveyor-belt.df9f4179-c5e8-11e7-bbb7-2a7ea17b5978/runs/a29adc80-6af1-4c1d-afea-6501eee63915/");
		executeCommand("ls;echo hi;echo hello;");
//		executeCommand("time");
		endCon();
	
	  }
	 
	  public static class MyUserInfo implements UserInfo{
	    public String getPassword(){ return passwd; }
	    public boolean promptYesNo(String str){
	        str = "Yes";
	        return true;}
	   
	    String passwd;
	 
	    public String getPassphrase(){ return null; }
	    public boolean promptPassphrase(String message){ return true; }
	    public boolean promptPassword(String message){
	        passwd="qaenv24"; // enter the password for the machine you want to connect.
	        return true;
	    }
	    public void showMessage(String message){
	    
	    }
	      } 
	  public static void endCon()
	  {
	    	  channel.disconnect();
		      session.disconnect();
	  }
	  public static void init() throws JSchException
	  {
		  String user=host.substring(0, host.indexOf('@'));
	      host=host.substring(host.indexOf('@')+1);
	 
	      session=jsch.getSession(user, host, 22);
	     
	      // username and password will be given via UserInfo interface.
	      UserInfo ui=new MyUserInfo();
	      session.setUserInfo(ui);
	      session.connect();
	 
//	      String command=  "cd /var/lib/mesos/slaves/fbf6e921-f495-4de8-b6f1-07cb2f0ed876-S3/frameworks/9d14cc2d-6bf0-43e0-9c67-494a1c12816f-0000/executors/neon_apps_platform_conveyor-belt.df9f4179-c5e8-11e7-bbb7-2a7ea17b5978/runs/a29adc80-6af1-4c1d-afea-6501eee63915/"; // enter any command you need to execute
	      channel=session.openChannel("exec");
	  }
 
		public static void executeCommand(String command){
			try{
			      
			      
			      
			      
			      ((ChannelExec)channel).setCommand(command);
//			      command="ls";
//			      channel=session.openChannel("exec");
//			      ((ChannelExec)channel).setCommand(command);
			      
			      channel.setInputStream(null);
			 
			      ((ChannelExec)channel).setErrStream(System.err);
			 
			      InputStream in=channel.getInputStream();
			 
			      channel.connect();
			 
			      byte[] tmp=new byte[1024];
			      while(true){
			        while(in.available()>0){
			          int i=in.read(tmp, 0, 1024);
			          if(i<0)break;
			          System.out.print(new String(tmp, 0, i));
			        }
			        if(channel.isClosed()){
			          System.out.println("exit-status: "+channel.getExitStatus());
			          break;
			        }
			        try{Thread.sleep(1000);}catch(Exception ee){}
			      }
			     
			    }
			    catch(Exception e){
			      System.out.println(e);
			    }
		}

	}


