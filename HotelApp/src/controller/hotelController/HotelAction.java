package controller.hotelController;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import hotel.Application;
import hotel.Hotel;

import hotel.Order;

public class HotelAction extends ActionSupport  {

	
    private List<Order> currentOrders;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		int hotelId=hotel.getHotelId();
	   setCurrentOrders(new ArrayList<Order>(app.getHotelCurrentOrders(hotelId).values()));
			               
	    return "success";
		 
	}
	
	public List<Order> getCurrentOrders() {
		return currentOrders;
	}
	public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

	

}
