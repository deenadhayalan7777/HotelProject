package controller.hotelController;


import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import hotel.Application;
import hotel.Hotel;

public class PreLogin implements SessionAware,ServletRequestAware {

	private Hotel hotel;
	
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
		
	 
		String hotelIdString=null;
		for(Cookie c : servletRequest.getCookies()) {
		    if (c.getName().equals("hotelId"))
		      hotelIdString=c.getValue();
		  }
		
		
		if(hotelIdString!=null)
		{
			Application app=Application.getInstance();
			
				int hotelId=Integer.parseInt(hotelIdString);
				hotel=app.getHotel(hotelId);
				
				  sessionMap.put("hotel", hotel);
				  
		  
			   return "alreadyLogged";
		}
	
		return "success";
	}

}
