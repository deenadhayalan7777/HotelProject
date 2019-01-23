package controller.agentController;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;
import hotel.C;

import hotel.HotelDetail;
import hotel.Order;
import hotel.User;



public class AgentAction extends ActionSupport {

	
    private List<HotelDetail> hotels;
    private List<Order> currentOrders;
   

	public List<HotelDetail> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDetail> hotels) {
		this.hotels = hotels;
	}

	public List<Order> getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

	
	
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Agent agent=(Agent) session.getAttribute("agent");
		int agentId=agent.getAgentId();
		setHotels(new ArrayList<HotelDetail>(app.getHotelList().values()));
		setCurrentOrders(new ArrayList<Order>(app.getAgentCurrentOrders(agentId).values()));
		
		return "success";
		
	}

	

}
