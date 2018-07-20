package com.waykichain.exchange.wallet;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="wallet")
public class WalletMessage {
	private String userName;
	private String password;
	private String IP;
	private String port;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIP() {
		return this.IP;
	}

	public void setIP(String iP) {
		this.IP = iP;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
