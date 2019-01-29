package controller.userController;





import java.util.Map;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;

import hotel.User;

public class LoginAction extends ActionSupport {

	
	private String username;
	private String password;
	private int x,y;
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
	
	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(username==null)  
	        addFieldError("username","Name can't be blank");  
	    if(password==null)  
	        addFieldError("password","Password must be greater than 5"); 
	    if(!username.matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		 Integer  userId=app.userLogin(username, password);
		 if(userId>0)
		 {
			 app.setUserLocation(userId,x,y);
			 User user=app.getUser(userId);
			 
			 ServletActionContext.getRequest().getSession().setAttribute("user", user);
			 
			
			 
			 return "success";
			 
		 }
		
		return "failure";
	}
	
	 
	


	
	
}
