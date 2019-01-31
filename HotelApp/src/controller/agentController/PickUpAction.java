package controller.agentController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;
import hotel.C;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Order;
import hotel.User;

public class PickUpAction extends ActionSupport{

	private int hotelId;
	private String orderslist;
	
	

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
		Gson gson = new Gson();
		
		List<Integer> orders=gson.fromJson(orderslist, new TypeToken<ArrayList<Integer>>(){}.getType());
		
		for(int orderId:orders)
		{
			app.addAgentOrder(agentId, orderId);
			app.setOrderStatus(orderId, C.ASSIGNED);
			app.setOrderTimer(orderId);
		
		}
		
		
		return "success";
	}


	public String getOrderslist() {
		return orderslist;
	}


	public void setOrderslist(String orderslist) {
		this.orderslist = orderslist;
	}
}
