package uk.specsavers.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class SMSNotificationService {
	
	
	String httpsURL="https://www.txtlocal.com/sendsmspost.php";
	
	public String sendSMSNotification(String contactNumber) throws Exception
	{
		
		String query="info="+URLEncoder.encode("1","UTF-8"); 
		query += "&";
		query += "test="+URLEncoder.encode("0","UTF-8") ;
		
		query += "&";
		query += "uname="+URLEncoder.encode("61mumbai61@gmail.com","UTF-8") ;
		
		query += "&";
		query += "pword="+URLEncoder.encode("Mumbai443","UTF-8") ;
		
		query += "&";
		query += "from="+URLEncoder.encode("Hackathon","UTF-8") ;
		
		query += "&";
		query += "selectednums="+URLEncoder.encode(contactNumber,"UTF-8") ;
		
		query += "&";
		query += "message="+URLEncoder.encode("This is to remind you that you have a hearing test in 5 days","UTF-8") ;
		
		
		
		String notificationResponse=doHttpUrlConnectionAction(httpsURL,query);
		
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
