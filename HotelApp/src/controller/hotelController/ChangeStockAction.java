package controller.hotelController;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import hotel.Application;
import hotel.Hotel;
import hotel.Item;

public class ChangeStockAction extends ActionSupport {

	
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
		Item item=app.getHotelMenu(hotel.getHotelId()).get(itemId);
		if(item.getStock()==0)
	      app.setItemStock(itemId,1);
		else
			app.setItemStock(itemId,0);
		
	    return "success";
		
	}

	
}
