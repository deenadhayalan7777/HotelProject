package controller.hotelController;


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
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Item;
import hotel.Order;
import hotel.User;



public class HotelAction extends ActionSupport implements ServletResponseAware {

	private int option;
    private List<Item> menu;
   
    private List<Order> myOrders;
	
    public void setOption(int option) {
		this.option = option;
	}
    public int getOption() {
		return option;
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
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		
		switch(option)
		  {
		 
		                              
		  case C.ADD_MENU: {
			                    		
			                    		 setMenu(new ArrayList<Item>(app.getHotelMenu(hotelId).values()));
									  
									 return "addMenu";
						}
		 
		  
		  case C.LIST_ORDER: {
			                 setMyOrders(new ArrayList<Order>(app.getHotelOrders(hotelId).values()));
			               
			             return "myOrders";
	                       }
		
		  case C.DISCOUNT: {
              setMyOrders(new ArrayList<Order>(app.getUserOrders(hotelId).values()));
            
          return "discount";
            }
		  case C.OPEN_CLOSE: {
			                int status=0;
                                if(hotel.getStatus()==0)
                                	status=1;
                               app.setHotelStatus(hotelId, status); 
                          return "success";     
                                	
            }
		  
		  case C.LOGOUT: {
		      session.invalidate();
		      Cookie ck = new Cookie("hotelId","" );
			  ck.setMaxAge(0); 
			  servletResponse.addCookie(ck);
			  return "logout";
	           					}
		  
		  }
	
		
		return "failure";
		
	}
	public List<Item> getMenu() {
		return menu;
	}
	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

	

}
