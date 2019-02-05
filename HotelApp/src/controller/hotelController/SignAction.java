package controller.hotelController;


import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


import hotel.Application;





public class SignAction extends ActionSupport {

	
	public String execute() 
	{
		Application app=Application.getInstance();
		
		List<String> locations=app.getLocationNames();	
	    ServletActionContext.getRequest().getSession().setAttribute("locations", locations);
		return "success";
		
	}



}
