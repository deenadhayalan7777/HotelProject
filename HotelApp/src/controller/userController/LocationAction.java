package controller.userController;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;
import hotel.Location;
import hotel.Order;
import hotel.User;


public class LocationAction extends ActionSupport {

	private int location;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		User user=(User) session.getAttribute("user");
		Location loc=app.getLocation(location);
		if(loc==null)
			System.out.println("Location null");
		else
		{app.setUserLocation(user.getUserId(), loc.getLocationId());
		user.setLocation(loc);
		}
	    return "success";
		
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}


	

	
	 
	


	
	
}
