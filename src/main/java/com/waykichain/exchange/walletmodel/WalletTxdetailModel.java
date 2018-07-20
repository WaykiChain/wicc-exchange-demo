package com.waykichain.exchange.walletmodel;

import java.math.BigDecimal;

public class WalletTxdetailModel {
	private String hash;
	private Integer height;
	private String txtype;
	private String addr;
	private String regid;
	private String desaddr;
	private String desregid;
	private BigDecimal money;
	private Integer ver;
	private Integer confirmedtime;
	private Integer confirmHeight;
	private BigDecimal fees;
	private String rawtx;
	private String Contract;
	private String blockhash;
	private String listOutput;

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getTxtype() {
		return this.txtype;
	}

	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRegid() {
		return this.regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	public String getDesaddr() {
		return this.desaddr;
	}

	public void setDesaddr(String desaddr) {
		this.desaddr = desaddr;
	}

	public String getDesregid() {
		return this.desregid;
	}

	public void setDesregid(String desregid) {
		this.desregid = desregid;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getVer() {
		return this.ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	public Integer getConfirmedtime() {
		return this.confirmedtime;
	}

	public void setConfirmedtime(Integer confirmedtime) {
		this.confirmedtime = confirmedtime;
	}

	public Integer getConfirmHeight() {
		return this.confirmHeight;
	}

	public void setConfirmHeight(Integer confirmHeight) {
		this.confirmHeight = confirmHeight;
	}

	public BigDecimal getFees() {
		return this.fees;
	}

	public void setFees(BigDecimal fees) {
		this.fees = fees;
	}

	public String getRawtx() {
		return this.rawtx;
	}

	public void setRawtx(String rawtx) {
		this.rawtx = rawtx;
	}

	public String getContract() {
		return this.Contract;
	}

	public void setContract(String contract) {
		this.Contract = contract;
	}

	public String getBlockhash() {
		return this.blockhash;
	}

	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}

	public String getListOutput() {
		return this.listOutput;
	}

	public void setListOutput(String listOutput) {
		this.listOutput = listOutput;
	}

	public String toString() {
		return "WalletTxdetailModel{hash=\'" + this.hash + '\'' + ", height=" + this.height + ", txtype=\'"
				+ this.txtype + '\'' + ", addr=\'" + this.addr + '\'' + ", regid=\'" + this.regid + '\''
				+ ", desaddr=\'" + this.desaddr + '\'' + ", desregid=\'" + this.desregid + '\'' + ", money="
				+ this.money + ", ver=" + this.ver + ", confirmedtime=" + this.confirmedtime + ", confirmHeight="
				+ this.confirmHeight + ", fees=" + this.fees + ", rawtx=\'" + this.rawtx + '\'' + ", Contract=\'"
				+ this.Contract + '\'' + ", blockhash=\'" + this.blockhash + '\'' + ", listOutput=\'" + this.listOutput
				+ '\'' + '}';
	}
}