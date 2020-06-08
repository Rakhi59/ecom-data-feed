package com.retail.ecom;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.data.VoucherData;
import com.retail.ecom.service.RawDataRetreiverService;
import com.retail.ecom.service.SaleVoucherService;

@RestController
public class DataRetrievalResource {

	@Autowired
	private RawDataRetreiverService datafeed;

	@Autowired
	private SaleVoucherService saleVoucherService;

	@RequestMapping("/raw")
	public Response retrieveRawData() {

		// person.setName(name);
		datafeed.getRawData();

		return Response.ok().build();
	}

	@RequestMapping(value = "/addVoucher", method = RequestMethod.POST, consumes = "application/json")
	public Response addSaleVoucher(@RequestBody VoucherData p) {
		saleVoucherService.addSaleVoucher();
		return Response.ok().build();
	}

	@RequestMapping(value = "/modifySaleVocher", method = RequestMethod.POST, consumes = "application/json")
	public Response modifySaleVoucher(@RequestBody VoucherData p) {
		saleVoucherService.modifySaleVoucherWithVoucherCode();
		return Response.ok().build();
	}

	@RequestMapping(value = "/modifySaleVocher/{number}", method = RequestMethod.POST, consumes = "application/json")
	public Response modifySaleVoucherUsingNumber(@RequestBody VoucherData p, @PathParam("number") String voucherNumber) {
		saleVoucherService.modifySaleVoucherWithVoucherNumber();
		return Response.ok().build();
	}
}
