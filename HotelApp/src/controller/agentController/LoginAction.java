package controller.agentController;



import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.Cookie;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;
import hotel.Hotel;

public class LoginAction extends ActionSupport implements SessionAware,ServletResponseAware{

	
	private String username;
	private String password;
	private SessionMap<String,Object> sessionMap;
	
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

	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap<String, Object>)map;  
	}  
	
	protected HttpServletResponse servletResponse;
	  @Override
	  public void setServletResponse(HttpServletResponse servletResponse) {
	    this.servletResponse = servletResponse;
	  }
	 
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		 Integer  agentId=app.agentLogin(username, password);
		 if(agentId>0)
		 {
			 Agent agent=app.getAgent(agentId);
			 sessionMap.put("hotel",agent.getAgentId() );
			  
			  Cookie ck = new Cookie("agentId",Integer.toString(agent.getAgentId()));
			  ck.setMaxAge(60*60*24*7); 
			  servletResponse.addCookie(ck);
			  
			 return "success";
			 
		 }
		
		return "failure";
	}
	
	 
	


	
	
}
