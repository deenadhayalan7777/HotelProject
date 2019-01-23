package controller.hotelController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;

import hotel.Order;


public class DiscountAction extends ActionSupport {

	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		Hotel hotel=(Hotel) ServletActionContext.getRequest().getSession().getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		
	    return "success";
		
	}


	
	 
	


	
	
}
