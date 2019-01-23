package controller.userController;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


import hotel.Application;
import hotel.C;

import hotel.HotelDetail;
import hotel.Order;
import hotel.User;



public class UserAction extends ActionSupport  {

	private int option;
   
    private List<Order> currentOrders;
    private List<Order> myOrders;
	
    public void setOption(int option) {
		this.option = option;
	}
    public int getOption() {
		return option;
	}



	public List<Order> getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(List<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

	public List<Order> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}

	
	

	
	public String execute() 
	{
		System.out.println("in user action " +option);
		Application app=Application.getInstance();
	   //HttpSession session=ServletActionContext.getRequest().getSession(); 
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		int userId=user.getUserId();
		
		switch(option)
		  {
		  
		  case C.MYORDERS: {
			                 setMyOrders(new ArrayList<Order>(app.getUserOrders(userId).values()));
			               
			             return "myOrders";
	                       }
		  case C.RATE_ORDER: {
              setCurrentOrders(new ArrayList<Order>(app.getUserCurrentOrders(userId).values()));
            
          return "rateOrder";
            }
		
		  case C.LOGOUT: {
		    
			  ServletActionContext.getRequest().getSession().invalidate();
		     
			  return "logout";
	           					}
		  
		  }
	
		
		return "failure";
		
	}

	

}
