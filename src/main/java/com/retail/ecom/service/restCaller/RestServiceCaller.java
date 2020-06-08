package com.retail.ecom.service.restCaller;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
public class RestServiceCaller {

	public Response getResponse(Builder builder){
		 return builder.header("UserName", "a").header("Pwd", "a").get();
	}
}
