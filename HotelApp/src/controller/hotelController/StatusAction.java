package controller.hotelController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;

import hotel.Order;


public class StatusAction extends ActionSupport {

	private String st;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		Hotel hotel=(Hotel) ServletActionContext.getRequest().getSession().getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		int status=0;
		st="CLOSE";
        if(hotel.getStatus()==0)
        	{status=1;
        	 st="OPEN";
        	}
         app.setHotelStatus(hotelId, status);
         hotel=app.getHotel(hotelId);
         ServletActionContext.getRequest().getSession().removeAttribute("hotel");
         ServletActionContext.getRequest().getSession().setAttribute("hotel", hotel);
   
	    return "success";
		
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}


	
	 
	


	
	
}
