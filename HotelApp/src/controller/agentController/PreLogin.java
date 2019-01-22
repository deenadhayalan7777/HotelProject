package controller.agentController;


import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import hotel.Agent;
import hotel.Application;
import hotel.User;

public class PreLogin implements SessionAware,ServletRequestAware {

	private Agent agent;
	
	private SessionMap<String,Object> sessionMap;
	
	@Override  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap<String, Object>)map;  
	}  
	
	
	
	 protected HttpServletRequest servletRequest;
	  @Override
	  public void setServletRequest(HttpServletRequest servletRequest) {
	    this.servletRequest = servletRequest;
	  }
	
public String execute() {
		
	 
		String agentIdString=null;
		for(Cookie c : servletRequest.getCookies()) {
		    if (c.getName().equals("agentId"))
		      agentIdString=c.getValue();
		  }
		
		
		if(agentIdString!=null)
		{
			Application app=Application.getInstance();
			
				int agentId=Integer.parseInt(agentIdString);
				agent=app.getAgent(agentId);
				
				  sessionMap.put("agent", agent);
				  
		  
			   return "alreadyLogged";
		}
	
		return "success";
	}

}
