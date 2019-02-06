package controller.hotelController;


import com.opensymphony.xwork2.ActionSupport;
import hotel.Application;

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
