package com.retail.ecom;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.service.RawDataRetreiver;

@RestController
public class RawDataFeed {

	@Autowired
	private RawDataRetreiver datafeed;
	
	@RequestMapping("/raw")
	public Response retrieveRawData( ) {
		
		
	//	person.setName(name);
		datafeed.getRawData();
		
		return Response.ok().build();
	}
	
	/*
	 * @RequestMapping(value="/person/update", method=RequestMethod.POST, consumes =
	 * "application/json") public Person updatePerson(@RequestBody Person p) {
	 * person.setName(p.getName()); return person; }
	 */
}
