package controller.userController;


import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import hotel.Application;
import hotel.User;

public class PreLogin implements SessionAware,ServletRequestAware {

	private User user;
	
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
		
	 
		String userIdString=null;
		for(Cookie c : servletRequest.getCookies()) {
		    if (c.getName().equals("userId"))
		      userIdString=c.getValue();
		  }
		
		
		if(userIdString!=null)
		{
			Application app=Application.getInstance();
			
				int userId=Integer.parseInt(userIdString);
				user=app.getUser(userId);
				
				  sessionMap.put("user", user);
				  
		  
			   return "alreadyLogged";
		}
	
		return "success";
	}

}
