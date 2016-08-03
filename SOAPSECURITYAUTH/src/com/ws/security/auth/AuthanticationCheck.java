package com.ws.security.auth;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class AuthanticationCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("http://localhost:8080/SOAPSECURITYAUTH/auth?wsdl");
		
		
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://auth.security.ws.com/", "HelloWorldImplService");
        System.out.println("---"+qname.getNamespaceURI());
//        System.out.println("---"+qname.get());

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
