package controller.agentController;



import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.Cookie;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;
import hotel.Hotel;

public class LoginAction extends ActionSupport {

	
	private String username;
	private String password;
	private int x;
	private int y;
	
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

 
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		 Integer  agentId=app.agentLogin(username, password);
		 if(agentId>0)
		 {
			 app.setAgentLocation(agentId,x,y);
			 Agent agent=app.getAgent(agentId);
			 ServletActionContext.getRequest().getSession().setAttribute("agent", agent);
			 
			 return "success";
			 
		 }
		
		return "failure";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	 
	


	
	
}
