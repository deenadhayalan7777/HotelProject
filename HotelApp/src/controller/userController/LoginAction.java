package controller.userController;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.Cookie;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.User;

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
		 Integer  userId=app.userLogin(username, password);
		 if(userId>0)
		 {
			 User user=app.getUser(userId);
			 List<HotelDetail> hotels=new ArrayList<HotelDetail>(app.getHotelList().values());
			 ServletActionContext.getRequest().getSession().setAttribute("user", user);
			 ServletActionContext.getRequest().getSession().setAttribute("hotels", hotels);
			 System.out.println("Updated login");
			 
			 return "success";
			 
		 }
		
		return "failure";
	}
	
	 
	


	
	
}
