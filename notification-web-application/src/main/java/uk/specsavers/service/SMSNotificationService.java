package uk.specsavers.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class SMSNotificationService {
	
	
	@Value("${messageapi.url}")
	private String notificationURL;
	
	@Value("${messageapi.username}")
	private String messageAPIUsername;
	
	@Value("${messageapi.password}")
	private String messageAPIPassword;
	
	@Value("${messageapi.sendername}")
	private String messageAPISendername;
	
	@Value("${messageapi.message}")
	private String message;
	
	
	
	public String sendSMSNotification(String contactNumber,String username) throws Exception
	{
		
		String query="info="+URLEncoder.encode("1","UTF-8"); 
		query += "&";
		query += "test="+URLEncoder.encode("0","UTF-8") ;
		
		query += "&";
		query += "uname="+URLEncoder.encode(messageAPIUsername,"UTF-8") ;
		
		query += "&";
		query += "pword="+URLEncoder.encode(messageAPIPassword,"UTF-8") ;
		
		query += "&";
		query += "from="+URLEncoder.encode(messageAPISendername,"UTF-8") ;
		
		query += "&";
		query += "selectednums="+URLEncoder.encode(contactNumber,"UTF-8") ;
		
		message=message.replace("{0}", username);
		query += "&";
		query += "message="+URLEncoder.encode(message,"UTF-8") ;
		
		
		
		String notificationResponse=doHttpUrlConnectionAction(notificationURL,query);
		
		return notificationResponse;
	}
	
	private String doHttpUrlConnectionAction(String httpsURL,String query) throws Exception
			  {

			    	URL myurl = new URL(httpsURL);
			    	HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
			    	con.setRequestMethod("POST");

			    	con.setRequestProperty("Content-length", String.valueOf(query.length())); 
			    	con.setRequestProperty("Content-Type","application/x-www-form-urlencoded"); 
			    	con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;Windows98;DigExt)"); 
			    	con.setDoOutput(true); 
			    	con.setDoInput(true);
			 
			    	DataOutputStream output = new DataOutputStream(con.getOutputStream());  


			    	output.writeBytes(query);

			    	output.close();

			    	DataInputStream input = new DataInputStream( con.getInputStream() ); 


			    	input.close(); 

			    	System.out.println("Resp Code:"+con .getResponseCode()); 
			    	System.out.println("Resp Message:"+ con .getResponseMessage());
			    	
			    	
			    	return con .getResponseMessage();
			  }
}
