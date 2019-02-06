package controller.agentController;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;
import hotel.C;

import hotel.Order;

public class PickUpAction extends ActionSupport{

	private int hotelId;
	private int number;
	
	

	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String execute()
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
	    Agent agent=(Agent) session.getAttribute("agent");
	    int agentId=agent.getAgentId();
	    Map<Integer,Order> orders=app.getHotelCurrentOrders(hotelId);
		
		
		
		for(Order order:orders.values())
		{
			if(order.getStatus()==C.ACCEPTED && order.getTimer()==0 && number>0)
			{
			int orderId=order.getOrderId();
			app.addAgentOrder(agentId, orderId);
			app.setOrderStatus(orderId, C.ASSIGNED);
			app.setOrderTimer(orderId);
			number--;
			}
			
		}
		
		
		return "success";
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	


	
}
