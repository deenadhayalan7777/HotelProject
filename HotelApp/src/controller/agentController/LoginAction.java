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
	private int locationId;
	
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
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

	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(username=="")  
	        addFieldError("username","Name can't be blank");  
	    if(password=="")  
	        addFieldError("password","Password can't be blank"); 
	    if(!username.matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		 Integer  agentId=app.agentLogin(username, password);
		 if(agentId>0)
		 {
			 app.setAgentLocation(agentId,locationId);
			 Agent agent=app.getAgent(agentId);
			 ServletActionContext.getRequest().getSession().setAttribute("agent", agent);
			 ServletActionContext.getRequest().getSession().setAttribute("locations", app.getLocationNames());
				
			 
			 return "success";
			 
		 }
		
		return "failure";
	}

	
	 
	


	
	
}
