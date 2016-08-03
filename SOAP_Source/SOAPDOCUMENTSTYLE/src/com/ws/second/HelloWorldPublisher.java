package com.ws.second;


import javax.xml.ws.Endpoint;


//Endpoint publisher
public class HelloWorldPublisher{
	
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9998/ws/secondhello", new HelloWorldImpl());
    }

}