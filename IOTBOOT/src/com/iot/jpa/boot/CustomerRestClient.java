package com.iot.jpa.boot;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

import com.iot.jpa.entity.Customer;
import com.iot.jpa.entity.Purchase;



public class CustomerRestClient {

	private static final String webServiceURI = "http://localhost:8080/SSIOTJPAREST";

	public static void main(String[] args) {
		
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("com.sun.jersey.config.property.packages", "com.iot.client");
		initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient();
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		String input = "{\"id\":\"12\",\"custname\":\"IOTONEEmployee\",\"cardid\":\"100000\",\"address\":\"Devloper\",\"purchages\":[{\"pid\":\"10000\",\"noofproducts\":\"100\",\"totalval\":\"20000\"},{\"pid\":\"12000\",\"noofproducts\":\"200\",\"totalval\":\"10000\"},{\"pid\":\"30000\",\"noofproducts\":\"300\",\"totalval\":\"30000\"}]}";
		// response
		System.out.println("====>"+args.length);
		System.out.println("====>"+args[0]);
		
		
		
		
		if(args.length>0)
		{
			Customer cust = new Customer();
			Purchase purc=new Purchase();
			purc.setId(new Long(100));
			purc.setNumberOfProducts(100);
			purc.setTotalValue(10000);
			Purchase purc1=new Purchase();
			purc1.setId(new Long(100));
			purc1.setNumberOfProducts(100);
			purc1.setTotalValue(10000);
			List<Purchase> purcList= new ArrayList<Purchase>();
			cust.setId(new Long(121));
			cust.setCardId("100011");
			cust.setAddress("Ameerpet");
			cust.setNome("kavya");
			purcList.add(purc);
			purcList.add(purc1);
			cust.setPurchases(purcList );
			
			if(args[0].equals("1"))
			{
				System.out.println("Post Methos:==>");
				System.out.println(webTarget.path("rest").path("employee").request()
						.accept(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.json(input)));
			} else if(args[0].equals("2"))
			{
				input = "{\"eid\":\"12\",\"ename\":\"IOTONEEmployee\",\"salary\":\"30000\",,\"deg\":\"Devloper\"}";
				System.out.println(webTarget.path("rest").path("employee").request()
						.accept(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.json(input)));
			} else 	if(args[0].equals("3"))
			{
				System.out.println("delete Method:==>");
				System.out.println(webTarget.path("rest").path("employee").request()
						.accept(MediaType.APPLICATION_JSON).delete(String.class));
			} else
			{
				System.out.println("get Method:==>");
				System.out.println(webTarget.path("rest").path("employee").getUri());
				System.out.println(webTarget.path("rest").path("employee").request().get(String.class));
			}
			
		}
		else
		{
			System.out.println("get Method:==>");
			System.out.println(webTarget.path("rest").path("employee").request().get(String.class));
		}
		
		/*System.out.println("Post Methos:==>");
		System.out.println(webTarget.path("rest").path("employee").request()
				.accept(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.json(emp)));
		
		
		System.out.println("Get Methos:==>");
		System.out.println(webTarget.path("rest").path("employee").request()
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		
		emp.setEid(121);
		emp.setEname("IOTEMPLOYEE");
		emp.setSalary(300000);
		emp.setDeg("Devloper");
		
		System.out.println("Put Methos:==>");
		
		System.out.println(webTarget.path("rest").path("employee").request()
				.accept(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.json(emp)));

		// xml		

		System.out.println("get Method:==>");
		System.out.println(webTarget.path("rest").path("employee").request()
				.accept(MediaType.APPLICATION_JSON).get(String.class));
		
		System.out.println("delete Method:==>");
		System.out.println(webTarget.path("rest").path("employee").request()
				.accept(MediaType.APPLICATION_JSON).delete(String.class));*/
	}
}
