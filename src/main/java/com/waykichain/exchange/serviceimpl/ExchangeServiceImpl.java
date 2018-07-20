package com.waykichain.exchange.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waykichain.exchange.wallet.WalletHelper;
import com.waykichain.exchange.wallet.WalletMessage;
import com.waykichain.exchange.walletmodel.WalletBlockModel;
import com.waykichain.exchange.walletmodel.WalletTxdetailModel;


@Service
public class ExchangeServiceImpl {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WalletMessage walletMessage;

	private int scanedBlockcount = 690551;
	
	public void scanBlcok() {
		logger.info("scanBlock starts...");
		
		WalletHelper walletHelper = new WalletHelper(walletMessage);
		
		int newBlockcount = walletHelper.getblockcount();	
		for (int i = scanedBlockcount + 1; i <= newBlockcount; i++) {
			WalletBlockModel walletBlockModel = walletHelper.getblock(i);	
			List<String> tx = walletBlockModel.getTx();
			if (tx != null){
				for (String tradeHash: tx){
					WalletTxdetailModel walletTxdetailModel = walletHelper.gettxdetail(tradeHash);
				//	System.out.println("JSON.toJSONString(walletTxdetailModel):" + JSON.toJSONString(walletTxdetailModel));
					String desaddr = walletTxdetailModel.getDesaddr();
					//TODO: 交易所私有代码处理部分
				}
			}
			scanedBlockcount++;
		}
	}
}
