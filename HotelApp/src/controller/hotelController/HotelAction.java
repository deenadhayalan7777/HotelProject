package controller.hotelController;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


import hotel.Application;
import hotel.C;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Item;
import hotel.Order;
import hotel.User;



public class HotelAction extends ActionSupport  {

	
    private List<Item> menu;
   
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
	public List<Item> getMenu() {
		return menu;
	}
	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}
	public List<Order> getCurrentOrders() {
		return currentOrders;
	}
	public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

	

}
