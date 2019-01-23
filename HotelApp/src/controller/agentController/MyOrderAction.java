package controller.agentController;



import java.util.ArrayList;
import java.util.List;




import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;

import hotel.Order;


public class MyOrderAction extends ActionSupport {

	 private List<Order> myOrders;
	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		Agent agent=(Agent) ServletActionContext.getRequest().getSession().getAttribute("agent");
		int agentId=agent.getAgentId();
		setMyOrders(new ArrayList<Order>(app.getAgentOrders(agentId).values())); 
		
	    return "success";
		
	}


	public List<Order> getMyOrders() {
		return myOrders;
	}


	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}
	
	 
	


	
	
}
