package com.retail.ecom.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.retail.ecom.service.restCaller.RestServiceCaller;

@Component
public class SaleVoucherService {

	@Autowired
	RestServiceCaller serviceCaller;

	public Response addSaleVoucher() {
		Client client = ClientBuilder.newClient();
		try {
			Builder build = client.target("http://103.209.147.187:981").request()
					.header("SC", "2")
					.header("VchType", "9")
					.header("VchXML", getAddSaleVoucher());
			return serviceCaller.getResponse(build);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			return null;
		}
	}

	public Response modifySaleVoucherWithVoucherCode() {
		Client client = ClientBuilder.newClient();
		try {
			Builder build = client.target("http://103.209.147.187:981").request()
					.header("SC", "4")
					.header("VchType", "9")
					.header("VchXML", getSaleVoucher())
					.header("VchCode", "1");
			return serviceCaller.getResponse(build);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			return null;
		}
	}

	public Response modifySaleVoucherWithVoucherNumber() {
		Client client = ClientBuilder.newClient();
		try {
			Builder build = client.target("http://103.209.147.187:981").request()
					.header("SC", "3")
					.header("VchType", "9")
					.header("VchXML", getSaleVoucherforVoucherNumber())
					.header("ModifyKey", "3"); //'ModifyKey = 3 = VchNo + Series + Date																							// Date
			return serviceCaller.getResponse(build);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			return null;
		}
	}

	private Object getSaleVoucherforVoucherNumber() {
		// TODO Auto-generated method stub
		String XMLStr = "<Sale>";
		XMLStr = XMLStr
				+ "<VchSeriesName>Main</VchSeriesName><Date>03-05-2020</Date><VchType>9</VchType><VchNo>1</VchNo><STPTName>L/GST-ItemWise</STPTName><MasterName1>Busy Infotech Pvt. Ltd.</MasterName1><MasterName2>Main Store</MasterName2>";
		XMLStr = XMLStr + "<VchOtherInfoDetails><Narration1>Sample Narration</Narration1></VchOtherInfoDetails>";

		XMLStr = XMLStr + "<ItemEntries>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>1</SrNo><ItemName>Item 1</ItemName><UnitName>Pcs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1120</Amt><STAmount>120</STAmount><STPercent>6</STPercent><STPercent1>6</STPercent1><TaxBeforeSurcharge>60</TaxBeforeSurcharge><TaxBeforeSurcharge1>60</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>2</SrNo><ItemName>Item 2</ItemName><UnitName>Kgs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1180</Amt><STAmount>180</STAmount><STPercent>9</STPercent><STPercent1>9</STPercent1><TaxBeforeSurcharge>90</TaxBeforeSurcharge><TaxBeforeSurcharge1>90</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>3</SrNo><ItemName>Item 3</ItemName><UnitName>Dozen</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1000</Amt><Exempted>True</Exempted><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr + "</ItemEntries>";

		XMLStr = XMLStr + "<BillSundries>";
		XMLStr = XMLStr
				+ "<BSDetail><SrNo>1</SrNo><BSName>Discount</BSName><PercentVal>10</PercentVal><Amt>330</Amt></BSDetail>";
		XMLStr = XMLStr + "</BillSundries>";
		XMLStr = XMLStr + "</Sale>";

		return XMLStr;
	}

	private static String getSaleVoucher() {

		String XMLStr = "<Sale>";
		XMLStr = XMLStr
				+ "<VchSeriesName>Main</VchSeriesName><Date>03-05-2020</Date><VchType>9</VchType><VchNo>1</VchNo><STPTName>L/GST-ItemWise</STPTName><MasterName1>Busy Infotech Pvt. Ltd.</MasterName1><MasterName2>Main Store</MasterName2>";
		XMLStr = XMLStr + "<VchOtherInfoDetails><Narration1>Sample Narration</Narration1></VchOtherInfoDetails>";

		XMLStr = XMLStr + "<ItemEntries>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>1</SrNo><ItemName>Item 1</ItemName><UnitName>RK Pcs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1120</Amt><STAmount>120</STAmount><STPercent>6</STPercent><STPercent1>6</STPercent1><TaxBeforeSurcharge>60</TaxBeforeSurcharge><TaxBeforeSurcharge1>60</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>2</SrNo><ItemName>Item 2</ItemName><UnitName>RK Kgs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1180</Amt><STAmount>180</STAmount><STPercent>9</STPercent><STPercent1>9</STPercent1><TaxBeforeSurcharge>90</TaxBeforeSurcharge><TaxBeforeSurcharge1>90</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>3</SrNo><ItemName>Item 3</ItemName><UnitName>RK Dozen</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1000</Amt><Exempted>True</Exempted><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr + "</ItemEntries>";

		XMLStr = XMLStr + "<BillSundries>";
		XMLStr = XMLStr
				+ "<BSDetail><SrNo>1</SrNo><BSName>Discount</BSName><PercentVal>10</PercentVal><Amt>330</Amt></BSDetail>";
		XMLStr = XMLStr
				+ "<BSDetail><SrNo>2</SrNo><BSName>Freight +amp; Forwarding Charges</BSName><Amt>100</Amt></BSDetail>";
		XMLStr = XMLStr + "</BillSundries>";
		XMLStr = XMLStr + "</Sale>";

		return XMLStr;
	}

	private static String getAddSaleVoucher() {

		String XMLStr = "<Sale>";
		XMLStr = XMLStr
				+ "<VchSeriesName>Main</VchSeriesName><Date>03-05-2020</Date><VchType>9</VchType><VchNo>1</VchNo><STPTName>L/GST-ItemWise</STPTName><MasterName1>Busy Infotech Pvt. Ltd.</MasterName1><MasterName2>Main Store</MasterName2>";
		XMLStr = XMLStr + "<VchOtherInfoDetails><Narration1>Sample Voucher by RK</Narration1></VchOtherInfoDetails>";

		XMLStr = XMLStr + "<ItemEntries>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>1</SrNo><ItemName>RK created ITEM 1</ItemName><UnitName>Pcs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1120</Amt><STAmount>120</STAmount><STPercent>6</STPercent><STPercent1>6</STPercent1><TaxBeforeSurcharge>60</TaxBeforeSurcharge><TaxBeforeSurcharge1>60</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>2</SrNo><ItemName>RK created ITEM 2</ItemName><UnitName>Kgs.</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1180</Amt><STAmount>180</STAmount><STPercent>9</STPercent><STPercent1>9</STPercent1><TaxBeforeSurcharge>90</TaxBeforeSurcharge><TaxBeforeSurcharge1>90</TaxBeforeSurcharge1><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr
				+ "<ItemDetail><SrNo>3</SrNo><ItemName>RK created ITEM 3</ItemName><UnitName>Dozen</UnitName><Qty>1</Qty><Price>1000</Price><Amt>1000</Amt><Exempted>True</Exempted><MC>Main Store</MC></ItemDetail>";
		XMLStr = XMLStr + "</ItemEntries>";

		XMLStr = XMLStr + "<BillSundries>";
		XMLStr = XMLStr
				+ "<BSDetail><SrNo>1</SrNo><BSName>Discount</BSName><PercentVal>10</PercentVal><Amt>330</Amt></BSDetail>";
		XMLStr = XMLStr + "</BillSundries>";
		XMLStr = XMLStr + "</Sale>";

		return XMLStr;
	}
}
