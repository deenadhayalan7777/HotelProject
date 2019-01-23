package controller.hotelController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;

import hotel.Order;


public class MyOrderAction extends ActionSupport {

	 private List<Order> myOrders;
	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		Hotel hotel=(Hotel) ServletActionContext.getRequest().getSession().getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		setMyOrders(new ArrayList<Order>(app.getHotelOrders(hotelId).values())); 
		
	    return "success";
		
	}


	public List<Order> getMyOrders() {
		return myOrders;
	}


	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}
	
	 
	


	
	
}
