package controller.hotelController;


import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;

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
		 Integer  hotelId=app.hotelLogin(username, password);
		 if(hotelId>0)
		 {
			 Hotel hotel=app.getHotel(hotelId);
			 ServletActionContext.getRequest().getSession().setAttribute("hotel", hotel);
			  
			 return "success";
			 
		 }
		
		return "failure";
	}
	
	 
	


	
	
}
