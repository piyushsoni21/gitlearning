package com.aerohive.association;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;

// @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@XmlRootElement
public class CliCommand {

	public CliCommand(){
		
	}
	
	//@JsonProperty("actionType")
	@XmlElement(name = "actionType")
	private String actionType;
	
	@XmlElement(name = "actionMethodType")
	private String actionMethodType;
	
	@XmlElement(name = "contextId")
	private String contextId;
	
	@XmlElement(name = "switchIp")
	private String switchIp;
	
	@XmlElement(name = "userName")
	private String userName;
	
	@XmlElement(name = "password")
	private String password;
	
	@XmlElement(name = "commands")
	private String commands;
	
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionMethodType() {
		return actionMethodType;
	}
	public void setActionMethodType(String actionMethodType) {
		this.actionMethodType = actionMethodType;
	}
	public String getContextId() {
		return contextId;
	}
	public void setContextId(String contextId) {
		this.contextId = contextId;
	}
	public String getSwitchIp() {
		return switchIp;
	}
	public void setSwitchIp(String switchIp) {
		this.switchIp = switchIp;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
	
	@Override
	public String toString() {
		return "CliCommand [actionType=" + actionType + ", actionMethodType="
				+ actionMethodType + ", contextId=" + contextId + ", switchIp="
				+ switchIp + ", userName=" + userName + ", password="
				+ password + ", commands=" + commands + "]";
	}
	
	
}
