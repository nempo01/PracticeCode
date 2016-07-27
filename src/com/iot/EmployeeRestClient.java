package com.iot;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;




public class EmployeeRestClient {

	private static final String webServiceURI = "http://localhost:8080/person/";

	public static void main(String[] args) {
		
		/*Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("com.sun.jersey.config.property.packages", "com.iot.client");
		initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");*/
		
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		String input = "{\"eid\":\"12\",\"ename\":\"IOTONEEmployee\",\"salary\":\"100000\",,\"deg\":\"Devloper\"}";
		// response
		System.out.println("====>"+args.length);
		System.out.println("====>"+args[0]);
		
		
		
		
		if(args.length>0)
		{
			/*Employee emp = new Employee();
			emp.setEid(121);
			emp.setEname("IOTEMPLOYEE");
			emp.setSalary(100000);
			emp.setDeg("Devloper");*/
			
			if(args[0].equals("1"))
			{
				System.out.println("Post Methos:==>");
				System.out.println(webTarget.path("save").request()
						.accept(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.json(input)));
			} else if(args[0].equals("2"))
			{
				input = "{\"eid\":\"12\",\"ename\":\"IOTONEEmployee\",\"salary\":\"30000\",,\"deg\":\"Devloper\"}";
				System.out.println(webTarget.path("save").request()
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