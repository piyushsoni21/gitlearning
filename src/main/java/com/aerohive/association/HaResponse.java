package com.aerohive.association;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HaResponse {
	
	@XmlElement
	private String hiveAgentSerialNumber;
	
	@XmlElement
	private int hiveAgentState;
	
	@XmlElement
	private int haPollFreq;
	
	@XmlElement
	private int msgRetryCount;
	
	@XmlElement
	private String hmngRestUrl;

	public String getHiveAgentSerialNumber() {
		return hiveAgentSerialNumber;
	}

	public void setHiveAgentSerialNumber(String hiveAgentSerialNumber) {
		this.hiveAgentSerialNumber = hiveAgentSerialNumber;
	}

	public int getHiveAgentState() {
		return hiveAgentState;
	}

	public void setHiveAgentState(int hiveAgentState) {
		this.hiveAgentState = hiveAgentState;
	}

	public int getHaPollFreq() {
		return haPollFreq;
	}

	public void setHaPollFreq(int haPollFreq) {
		this.haPollFreq = haPollFreq;
	}

	public int getMsgRetryCount() {
		return msgRetryCount;
	}

	public void setMsgRetryCount(int msgRetryCount) {
		this.msgRetryCount = msgRetryCount;
	}

	public String getHmngRestUrl() {
		return hmngRestUrl;
	}

	public void setHmngRestUrl(String hmngRestUrl) {
		this.hmngRestUrl = hmngRestUrl;
	}

}
