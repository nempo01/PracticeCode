package com.ws.security;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ws.security.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String getHelloWorldAsString() {
		// TODO Auto-generated method stub
		return "Security TEST";
	}
	

}
