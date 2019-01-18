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



public class UserAction extends ActionSupport implements ServletResponseAware {

	private int option;
    private List<HotelDetail> hotels;
    private List<Order> currentOrders;
    private List<Order> myOrders;
	
    public void setOption(int option) {
		this.option = option;
	}
    public int getOption() {
		return option;
	}

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

	public List<Order> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}

	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	
	
	protected HttpServletResponse servletResponse;
	  @Override
	  public void setServletResponse(HttpServletResponse servletResponse) {
	    this.servletResponse = servletResponse;
	  }
	
	public String execute() 
	{
		System.out.println("in user action " +option);
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		User user=(User) session.getAttribute("user");
		int userId=user.getUserId();
		
		switch(option)
		  {
		 
		                              
		  case C.HOTELS: {
			                    		setHotels(new ArrayList<HotelDetail>(app.getHotelList().values()));
									System.out.println("In hotels");
									  
									 return "hotelList";
						}
		  
		  
		  case C.MYORDERS: {
			                 setMyOrders(new ArrayList<Order>(app.getUserOrders(userId).values()));
			               
			             return "myOrders";
	                       }
		  case C.CURR_ORDERS:{
			          setCurrentOrders(new ArrayList<Order>(app.getUserCurrentOrders(userId).values()));
		               
		             return "currentOrders";
			  
		  }
		  case C.LOGOUT: {
		      session.invalidate();
		      Cookie ck = new Cookie("username","" );
			  ck.setMaxAge(0); 
			  servletResponse.addCookie(ck);
			  return "logout";
	           					}
		  
		  }
	
		
		return "failure";
		
	}

	

}
