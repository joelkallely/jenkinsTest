package baseClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;

public class MarathonHelper {
	//////////////////////SCALE CONTAINER///////////////////////////////////////
	public static void scaleContainer(String env,String container,String instance) throws IOException{
	//env = 192.168.150.45
	//container = neon/apps/platform/dfe
	Random random = new Random();
  URL url = new URL("http://"+env+":8080/v2/apps//"+container+"?embed=app.taskStats&embed=app.readiness");
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  String userpassword = "flyuser" + ":" + "flypassWORD";
      String encodedAuthorization = new Base64().encodeToString(userpassword.getBytes() );
      connection.setRequestProperty("Authorization", "Basic "+
            encodedAuthorization);
  connection.setRequestMethod("PUT");
  connection.setDoOutput(true);
  connection.setRequestProperty("Content-Type", "application/json");
  connection.setRequestProperty("Accept", "application/json");
  OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
  osw.write(String.format("{\"instances\":"+instance+"}", random.nextInt(30), random.nextInt(20)));
  osw.flush();
  osw.close();
  System.err.println(connection.getResponseCode());
	}
	////////////////////////GET MARATHON CONTAINER STATUS///////////////////////////////////////
	public static int getContainerStatus(String env,String container) throws IOException{
		//env = 192.168.150.45
		//container = neon/apps/platform/dfe
		String USER_AGENT = "Mozilla/5.0";
		String url = "http://"+env+":8080/v2/apps//"+container+"?embed=app.taskStats&embed=app.readiness";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//authentication for marathon
		//result = new Base64().encodeToString(rawHmac);
	      String userpassword = "flyuser" + ":" + "flypassWORD";
	      String encodedAuthorization = new Base64().encodeToString( userpassword.getBytes() );
	      con.setRequestProperty("Authorization", "Basic "+
	            encodedAuthorization);

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String JSONStr = response.toString();
		int runIndexbeg = JSONStr.indexOf("tasksRunning");
		int runIndexend = JSONStr.indexOf(",\"tasksHealthy");
		String instances = JSONStr.substring(runIndexbeg, runIndexend);
		String[] num = instances.split(":");
		int n = Integer.parseInt(num[1]);
		System.out.println(n);
		
		//return result
		return n;
	}
	
	
}
