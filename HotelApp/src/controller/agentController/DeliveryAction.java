package controller.agentController;

import java.util.ArrayList;
import java.util.Arrays;
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

public class DeliveryAction extends ActionSupport{

	private int sno;
	

	public String execute()
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Agent agent=(Agent) session.getAttribute("agent");
		
		
		Order order=new ArrayList<Order>(app.getAgentCurrentOrders(agent.getAgentId()).values()).get(sno);
		app.setOrderStatus(order.getOrderId(), C.DELIVERED);
			
		return "success";
	}


	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}
}
