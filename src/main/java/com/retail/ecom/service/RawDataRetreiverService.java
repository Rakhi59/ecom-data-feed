package com.retail.ecom.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
public class RawDataRetreiverService {
	
	public void getRawData(){
		Client client = ClientBuilder.newClient();
	       try {
	    	   Response res = client.target("http://103.209.147.187:981").request()
	    			   		  .header("Qry", "Select * from Master1 where Code=7")	    	
	    			   		  .header("UserName", "a").header("SC", "1")
	    			   		  .header("Pwd", "a").get();
	    	   System.out.println("Result is "+ res.readEntity(String.class));
	    	   System.out.println("Result is2  "+ res.getStatus());
	       } catch(Exception e) {
	    	   System.out.println("Exception is "+e.getMessage());
	       }
	}
}
