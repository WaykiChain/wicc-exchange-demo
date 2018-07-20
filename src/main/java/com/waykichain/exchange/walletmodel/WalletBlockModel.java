package com.waykichain.exchange.walletmodel;

import java.util.List;

/*
{"hash":"d83273711ad86766a1a4ee06bb444a5a7fcf815a66f0b0e35316dff311db8d49","confirmations":228,"size":434,
	"height":689072,"version":1,"merkleroot":"3c056d2b900a4264f60085302567346c932316c9601614cc04bc10ab00e4f3e9",
	"txnumber":3,"tx":["ee4c16ae832384ab36044beb3394b2ec13287bbfdaf1f06d412d6eda6c61fc25",
	                   "36a903f115aeaec42fb6fb3da287359cdcaae5294a211a352b6e075f8887f741","65a90c7be70ffee268c6d5edd73159fadbf0ecbbef98c3afbfb77abf2796c16b"],
	"time":1523494540,"nonce":937,"chainwork":"00000000000000000000000000000000000000000000000000000000000a83b0","fuel":34,"fuelrate":1,
	"previousblockhash":"e13564b571b2cfffca99314d00c93be8926c86811cf4cc1e77d6f45b1739659e","nextblockhash":"aa18845989554f5b7056be430c673140cab0e9136692344acfff7ad108f07783"},
*/
public class WalletBlockModel {
	
	private String hash;
	private Integer confirmations;
	private Integer size;
	private Integer height;
	private Integer txnumber;
	private List<String> tx;
	private long time;
	private Integer nonce;
	private String merkleroot;
	
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Integer getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(Integer confirmations) {
		this.confirmations = confirmations;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getTxnumber() {
		return txnumber;
	}
	public void setTxnumber(Integer txnumber) {
		this.txnumber = txnumber;
	}
	public List<String> getTx() {
		return tx;
	}
	public void setTx(List<String> tx) {
		this.tx = tx;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public Integer getNonce() {
		return nonce;
	}
	public void setNonce(Integer nonce) {
		this.nonce = nonce;
	}
	public String getMerkleroot() {
		return merkleroot;
	}
	public void setMerkleroot(String merkleroot) {
		this.merkleroot = merkleroot;
	}
	
}
