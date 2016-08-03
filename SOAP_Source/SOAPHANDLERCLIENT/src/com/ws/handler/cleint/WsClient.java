package com.ws.handler.cleint;

import com.ws.handler.ServerInfo;
import com.ws.handler.ServerInfoService;

public class WsClient {
	public static void main(String[] args) throws Exception {

		ServerInfoService sis = new ServerInfoService();
		ServerInfo si = sis.getServerInfoPort();

		System.out.println(si.getServerName());

	}
}
