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

public class UserAction extends ActionSupport {

	 private List<HotelDetail> hotels;
	
	
	public List<HotelDetail> getHotels() {
		return hotels;
	}


	public void setHotels(List<HotelDetail> hotels) {
		this.hotels = hotels;
	}


	public String execute() 
	{
		
		Application app=Application.getInstance();
		
		 hotels=new ArrayList<HotelDetail>(app.getHotelList().values());
		 
		 
		
	    return "success";
		
	}


	
	
	 
	


	
	
}
