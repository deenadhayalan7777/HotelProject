package controller.userController;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import javax.servlet.http.Cookie;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Order;
import hotel.User;

public class MyOrderAction extends ActionSupport {

	 private List<Order> myOrders;
	 private List<Order> currentOrders;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		int userId=user.getUserId();
		setMyOrders(new ArrayList<Order>(app.getUserOrders(userId).values())); 
		setCurrentOrders(new ArrayList<Order>(app.getUserCurrentOrders(userId).values())); 
	    return "success";
		
	}


	public List<Order> getMyOrders() {
		return myOrders;
	}


	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}


	public List<Order> getCurrentOrders() {
		return currentOrders;
	}


	public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}
	
	
}
