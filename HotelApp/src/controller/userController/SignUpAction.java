package controller.userController;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import hotel.Application;
import hotel.User;




public class SignUpAction extends ActionSupport implements ModelDriven<User> {

	private User user;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel(){  
	    user=new User();  
	    return user;  
	}
	
	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(user.getUsername()==null)  
	        addFieldError("username","Name can't be blank");  
	    if(user.getPassword()==null)  
	        addFieldError("password","Password must be greater than 5"); 
	    if(user.getPhone()==null)  
	        addFieldError("phone","PhoneNo  can't be blank");  
	    if(!user.getUsername().matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		Application app=Application.getInstance();
		int userId=app.userSignUp(user.getUsername(), user.getPassword(), user.getPhone());
		
		if(userId>0)
		return "success";
		
		return "failure";
	}

}
