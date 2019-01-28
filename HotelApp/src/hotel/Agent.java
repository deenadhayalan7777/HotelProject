package hotel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Agent implements Serializable {

	private int agentId;
	private String username;
	private String password;
	private String phone;
	private Location location;
	
	
	public Agent()
	{
		
	}
	
	public Agent(int agentId, String username, String password, String phone,int x,int y) {
		
		this.agentId = agentId;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.location=new Location(x,y);
		
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
}
