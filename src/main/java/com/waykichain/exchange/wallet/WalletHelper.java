package com.waykichain.exchange.wallet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.waykichain.exchange.utils.JsonRpcReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.waykichain.exchange.utils.CommonConstants;
import com.waykichain.exchange.utils.HttpUtil;
import com.waykichain.exchange.utils.JsonRpcRes;
import com.waykichain.exchange.walletmodel.WalletBlockModel;
import com.waykichain.exchange.walletmodel.WalletNewAddressModel;
import com.waykichain.exchange.walletmodel.WalletTxdetailModel;

public class WalletHelper {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private WalletMessage walletMessage;
	private String url;
	
	private  String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	public WalletHelper(WalletMessage walletMessage) {
		this.walletMessage = walletMessage;
		this.url = "http://" + walletMessage.getUserName() + ":" + walletMessage.getPassword() + "@" + walletMessage.getIP() + ":" + walletMessage.getPort();
	}
	
	public WalletHelper(String url) {
		this.url = url;
	}
	
	
	public WalletNewAddressModel getnewaddress() {
		List<Object> params = new ArrayList<Object>();
		params.add(false);
		Object jsonRpcResult = rpcHttpAction("getnewaddress", params);	
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		WalletNewAddressModel walletNewAddress = JSONObject.toJavaObject(jsonObj, WalletNewAddressModel.class);
		return walletNewAddress;
	}
	
	public String registaccounttx(String address) {
		List<Object> params = new ArrayList<Object>();
		params.add(address);
		params.add(1000000);
		Object jsonRpcResult = rpcHttpAction("registaccounttx", params);	
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		return jsonObj.getString("hash") ;
	}
	
	public double getbalance(String addr) {
		List<Object> params = new ArrayList<Object>();		
		if(addr!=null && !"".equals(addr.trim())) {
			params.add(addr);
		}
		Object jsonRpcResult = rpcHttpAction("getbalance", params);		
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		
	//	WalletModel walletModel = JSONObject.toJavaObject(jsonObj, WalletModel.class);	
	//	return walletModel.getBalance();
		System.out.println("jsonObj:" + jsonObj.getDoubleValue("balance"));		
		return jsonObj.getDoubleValue("balance");
	}
	
	public int getblockcount() {
		Object jsonRpcResult = rpcHttpAction("getblockcount", Collections.emptyList());
		Integer result = (Integer)jsonRpcResult;
		return result;
	}
	
	public boolean walletlock() {
		Object jsonRpcResult = rpcHttpAction("walletlock", Collections.emptyList());
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		return jsonObj.getBooleanValue("walletlock");
	}
	
	public void walletpassphrase(String password) {
		List<Object> params = new ArrayList<Object>();
		params.add(password);
		params.add(600);
		Object jsonRpcResult = rpcHttpAction("walletpassphrase", params);		
	}
	
	public WalletBlockModel getblock(int blockHight) {
		List<Object> params = new ArrayList<Object>();
		params.add(blockHight);
		Object jsonRpcResult = rpcHttpAction("getblock", params);
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		WalletBlockModel walletBlockModel = JSONObject.toJavaObject(jsonObj, WalletBlockModel.class);
		return walletBlockModel;
	}
	
	public String sendtoaddress(String recvAddr, double amount) {
		List<Object> params = new ArrayList<Object>();
		params.add(recvAddr);
		params.add(amount);
		Object jsonRpcResult = rpcHttpAction("sendtoaddress", params);
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		return jsonObj.getString("hash") ;
	}
	

	public WalletTxdetailModel gettxdetail(String tradeHash) {
		List<Object> params = new ArrayList<Object>();
		params.add(tradeHash); //
		Object jsonRpcResult = rpcHttpAction("gettxdetail", params);
		JSONObject jsonObj = (JSONObject)jsonRpcResult;
		WalletTxdetailModel walletTxdetailModel = JSONObject.toJavaObject(jsonObj, WalletTxdetailModel.class);
		return walletTxdetailModel;
	}
	
	public void debug() {
		Object jsonRpcResult = rpcHttpAction("walletlock", Collections.emptyList());		
	}
	
	public Object rpcHttpAction(String method, List<Object> params){			
		JsonRpcReq jsonRpcReq = new JsonRpcReq();
		jsonRpcReq.setMethod(method);
		jsonRpcReq.setParams(params);
		jsonRpcReq.setId(1);
		jsonRpcReq.setJsonrpc(CommonConstants.JSONRPC_DEFAULT);
		String postData = JSON.toJSONString(jsonRpcReq);
		String httpResult = HttpUtil.post(url, postData);
		logger.info("Method " + method + ",post data:" + params + ",ethResult:" + httpResult);
	
		JsonRpcRes ethRpcRes = JSON.parseObject(httpResult, JsonRpcRes.class);
		return ethRpcRes.getResult();	
	}
	
	public static void main(String[] args) {		
		WalletMessage walletMessage = new WalletMessage();
		walletMessage.setIP("localhost");
		walletMessage.setPort("6968");
		walletMessage.setUserName("water");
		walletMessage.setPassword("password");		
		WalletHelper walletHelper = new WalletHelper(walletMessage);
		
		String password = "Wicc123456";		
		walletHelper.walletpassphrase(password);
	//	System.out.println("walletHelper.getnewaddress():" + JSON.toJSONString(walletHelper.getnewaddress()));
		
		String registResult = walletHelper.registaccounttx("wcxpPN1cUFUvYzDd1xJiNjWZSWoTej4Jxi");
		System.out.println("registResult:" + registResult);
		
//		System.out.println(walletHelper.getbalance("wduNJKarPTNwdS8Mr2Dwsz86bETmLuPe1s"));
	//	System.out.println(walletHelper.getblockcount());
	//	System.out.println(walletHelper.walletlock());
	//	walletHelper.walletpassphrase();
	//	walletHelper.debug();
	//	walletHelper.walletpassphrase();
		
/*		WalletBlockModel walletBlockModel = walletHelper.getblock(689072);	
		List<String> tx = walletBlockModel.getTx();
		if(tx!=null) {
			for(String tradeHash: tx) {
				WalletTxdetailModel walletTxdetailModel = walletHelper.gettxdetail(tradeHash);
				System.out.println("JSON.toJSONString(walletTxdetailModel):" + JSON.toJSONString(walletTxdetailModel));
			}
		}*/
		
		
//		WalletTxdetailModel walletTxdetailModel = walletHelper.gettxdetail("8739ba457bd10300f8294fd3244e2ad04f329cac3692cd42191d62a72d467ed1");
//		WalletTxdetailModel walletTxdetailModel = walletHelper.gettxdetail("36a903f115aeaec42fb6fb3da287359cdcaae5294a211a352b6e075f8887f741");
//		System.out.println("JSON.toJSONString(walletTxdetailModel):" + JSON.toJSONString(walletTxdetailModel));
		
//		System.out.println(walletHelper.sendtoaddress("wU66ep4ERtn8NcUYT8YKNMBJf93pqE1mWb", 110000000));
		

	}
	


}
