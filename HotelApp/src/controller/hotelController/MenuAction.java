package controller.hotelController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;
import hotel.Item;
import hotel.Order;


public class MenuAction extends ActionSupport {

	 private List<Item> menu;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		Hotel hotel=(Hotel) ServletActionContext.getRequest().getSession().getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		 setMenu(new ArrayList<Item>(app.getHotelMenu(hotelId).values()));
	    return "success";
		
	}


	public List<Item> getMenu() {
		return menu;
	}


	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}



	 
	


	
	
}
