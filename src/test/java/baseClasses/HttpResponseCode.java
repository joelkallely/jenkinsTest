package baseClasses;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpResponseCode  extends browserInit {

    public static String getRequest(String url) throws IOException{
    	String USER_AGENT = "Mozilla/5.0";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

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

		//return result
		return response.toString();
    }
 // HTTP POST request
 	public static void vcustHit(String customerHit,String dest) throws Exception {
 		
 		String USER_AGENT = "Mozilla/5.0";
 		String url = "http://env24-node3.flytxt.com:31503/inject_mo";
 		URL obj = new URL(url);
 		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

 		//add reuqest header
 		con.setRequestMethod("POST");
 		con.setRequestProperty("User-Agent", USER_AGENT);
 		con.setRequestProperty("Accept-Language", "en-US,en;q=0.9");

 		String urlParameters = "short_message=lang&source_addr="+customerHit+"&destination_addr="+dest+"&charset=1&submit=Submit+Message&service_type=&source_addr_ton=1&source_addr_npi=1&dest_addr_ton=1&dest_addr_npi=1&esm_class=0&protocol_ID=&priority_flag=&registered_delivery_flag=0&data_coding=4&user_message_reference=&source_port=&destination_port=&sar_msg_ref_num=&sar_total_segments=&sar_segment_seqnum=&user_response_code=&privacy_indicator=&payload_type=&message_payload=&callback_num=&source_subaddress=&dest_subaddress=&language_indicator=&tlv1_tag=Unrecognised+Parameter+name+%24%24tlv1_tag%24%24&tlv1_len=Unrecognised+Parameter+name+%24%24tlv1_len%24%24&tlv1_val=Unrecognised+Parameter+name+%24%24tlv1_val%24%24&tlv2_tag=Unrecognised+Parameter+name+%24%24tlv2_tag%24%24&tlv2_len=Unrecognised+Parameter+name+%24%24tlv2_len%24%24&tlv2_val=Unrecognised+Parameter+name+%24%24tlv2_val%24%24&tlv3_tag=Unrecognised+Parameter+name+%24%24tlv3_tag%24%24&tlv3_len=Unrecognised+Parameter+name+%24%24tlv3_len%24%24&tlv3_val=Unrecognised+Parameter+name+%24%24tlv3_val%24%24&tlv4_tag=Unrecognised+Parameter+name+%24%24tlv4_tag%24%24&tlv4_len=Unrecognised+Parameter+name+%24%24tlv4_len%24%24&tlv4_val=Unrecognised+Parameter+name+%24%24tlv4_val%24%24";

 		// Send post request
 		con.setDoOutput(true);
 		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
 		wr.writeBytes(urlParameters);
 		wr.flush();
 		wr.close();

 		int responseCode = con.getResponseCode();
 		System.out.println("\nSending 'POST' request to URL : " + url);
 		System.out.println("Post parameters : " + urlParameters);
 		System.out.println("Response Code : " + responseCode);

 		BufferedReader in = new BufferedReader(
 		        new InputStreamReader(con.getInputStream()));
 		String inputLine;
 		StringBuffer response = new StringBuffer();

 		while ((inputLine = in.readLine()) != null) {
 			response.append(inputLine);
 		}
 		in.close();

 		//print result
 		System.out.println(response.toString());

 	}
}