package com.mkyong.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class HttpsClient{
	
   public static void main(String[] args)
   {
        new HttpsClient().testIt();
   }
	
   private void testIt(){
	   
	// Create a trust manager that does not validate certificate chains
	/*
		TrustManager[] trustAllCerts = new TrustManager[] { 
		  new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() { 
			  return new X509Certificate[0]; 
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType) {}
			public void checkServerTrusted(X509Certificate[] certs, String authType) {}
		}};

		// Ignore differences between given hostname and certificate hostname
		HostnameVerifier hv = new HostnameVerifier() {
		  public boolean verify(String hostname, SSLSession session) { return true; }
		};

		// Install the all-trusting trust manager
		try {
		  SSLContext sc = SSLContext.getInstance("SSL");
		  sc.init(null, trustAllCerts, new SecureRandom());
		  HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		  HttpsURLConnection.setDefaultHostnameVerifier(hv);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 */
	  System.out.println("-------------------------------------");
	  
	  System.out.println(System.getProperty("java.home"));
	  System.out.println(System.getProperty("javax.net.ssl.keyStoreType"));
	  System.out.println(System.getProperty("javax.net.ssl.keyStore"));
	  System.out.println(System.getProperty("Djavax.net.ssl.trustStoreType"));
	  System.out.println(System.getProperty("javax.net.ssl.trustStore"));
	  
	  
	  System.out.println("-------------------------------------");
	  
	  if (1==2){
		return;  
	  }
	  
      String https_url = "https://www.google.com/";
	  //String https_url = "https://dth298067l:7002/console/login/LoginForm.jsp";
	  
      URL url;
      try {

	     url = new URL(https_url);
	     HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
			
	     //dumpl all cert info
	     print_https_cert(con);
			
	     //dump all the content
	     print_content(con);
			
      } catch (MalformedURLException e) {
	     e.printStackTrace();
      } catch (IOException e) {
	     e.printStackTrace();
      }

   }
	
   private void print_https_cert(HttpsURLConnection con){
     
    if(con!=null){
			
      try {
				
	System.out.println("Response Code : " + con.getResponseCode());
	System.out.println("Cipher Suite : " + con.getCipherSuite());
	System.out.println("\n");
				
	Certificate[] certs = con.getServerCertificates();
	for(Certificate cert : certs){
	   System.out.println("Cert Type : " + cert.getType());
	   System.out.println("Cert Hash Code : " + cert.hashCode());
	   System.out.println("Cert Public Key Algorithm : " 
                                    + cert.getPublicKey().getAlgorithm());
	   System.out.println("Cert Public Key Format : " 
                                    + cert.getPublicKey().getFormat());
	   System.out.println("\n");
	}
				
	} catch (SSLPeerUnverifiedException e) {
		e.printStackTrace();
	} catch (IOException e){
		e.printStackTrace();
	}

     }
	
   }
	
   private void print_content(HttpsURLConnection con){
		if(con!=null){
				
			try {
				
			   System.out.println("****** Content of the URL ********");			
			   BufferedReader br = 
				new BufferedReader(
					new InputStreamReader(con.getInputStream()));
						
			   String input;
						
			   while ((input = br.readLine()) != null){
				  System.out.println(input);
			   }
			   br.close();
						
			} catch (IOException e) {
			   e.printStackTrace();
			}
				
	   }
		
   }
	
}