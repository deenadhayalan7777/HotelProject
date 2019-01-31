package controller.userController;





import java.util.ArrayList;
import java.util.List;
import java.util.Map;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Location;
import hotel.User;

public class LoginAction extends ActionSupport {

	
	private String username;
	private String password;
	
	
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
		 Integer  userId=app.userLogin(username, password);
		 if(userId>0)
		 {
			 
			 User user=app.getUser(userId);
			 
			 List<String> locations=app.getLocationNames();
			 ServletActionContext.getRequest().getSession().setAttribute("user", user);
			 ServletActionContext.getRequest().getSession().setAttribute("locations", locations);
			
			 return "success";
			 
		 }
		
		return "failure";
	}
	
	 
	


	
	
}
