package com.ws.first;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;



public class SOAPClient {
	public static void main(String[] args) throws Exception {
		   
	URL url = new URL("http://localhost:9999/ws/hello?wsdl");
	
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://first.ws.com/", "HelloWorldImplService");
        System.out.println("---"+qname.getNamespaceURI());
//        System.out.println("---"+qname.get());

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("helloworld"));

    }

}
