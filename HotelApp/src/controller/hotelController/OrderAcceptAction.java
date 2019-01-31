package controller.hotelController;




import java.util.Date;



import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.C;
import hotel.Order;





public class OrderAcceptAction extends ActionSupport {

	private int stock;
	private int orderId;
	

	public String execute() 
	{
		
		Application app=Application.getInstance();
		
        app.setOrderStatus(orderId, C.ACCEPTED);
        app.setOrderTimer(orderId);
        Order order=app.getOrder(orderId);
        app.getCurrentOrders().put(orderId, order);
	    return "success";
		
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	
	 
	


	
	
}
