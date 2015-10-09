package com.aerohive.association;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HaRequest {
	@XmlElement
	private long hiveAgentSerialNumber;

	public long getHiveAgentSerialNumber() {
		return hiveAgentSerialNumber;
	}

	public void setHiveAgentSerialNumber(long hiveAgentSerialNumber) {
		this.hiveAgentSerialNumber = hiveAgentSerialNumber;
	}

	@Override
	public String toString() {
		return "HaRequest [hiveAgentSerialNumber=" + hiveAgentSerialNumber
				+ "]";
	}	
	
	
}
