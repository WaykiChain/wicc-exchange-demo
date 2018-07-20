package com.waykichain.exchange.wallettest;

import com.waykichain.exchange.wallet.WalletHelper;
import org.junit.Test;
import com.waykichain.exchange.wallet.WalletMessage;

public class WalletHelperTest {

	@Test
	public void test() {	
		WalletMessage walletMessage = new WalletMessage();
		walletMessage.setIP("localhost");
		walletMessage.setPort("6968");
		walletMessage.setUserName("water");
		walletMessage.setPassword("password");		
		WalletHelper walletHelper = new WalletHelper(walletMessage);
		
	//	System.out.println(JSON.toJSONString(walletHelper.getbalance()));
		walletHelper.getblockcount();
		
	}
	
}
