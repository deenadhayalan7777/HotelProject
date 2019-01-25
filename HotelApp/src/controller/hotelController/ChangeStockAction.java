package controller.hotelController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;

import hotel.Order;


public class ChangeStockAction extends ActionSupport {

	private int stock;
	private int itemId;
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String execute() 
	{
		
		Application app=Application.getInstance();
		Hotel hotel=(Hotel) ServletActionContext.getRequest().getSession().getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		
        
         app.setItemStock(itemId, stock);
         
	    return "success";
		
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	
	 
	


	
	
}
