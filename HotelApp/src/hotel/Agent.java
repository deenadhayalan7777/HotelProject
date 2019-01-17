package hotel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Agent implements Serializable {

	private int agentId;
	private String username;
	private String password;
	private String phone;
	
	
	
	public Agent()
	{
		
	}
	
	public Agent(int agentId, String username, String password, String phone) {
		
		this.agentId = agentId;
		this.username = username;
		this.password = password;
		this.phone = phone;
		
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}