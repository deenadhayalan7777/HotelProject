package controller.agentController;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Item;
import hotel.Order;

public class SelectHotelAction extends ActionSupport implements SessionAware{

	private int sno;
	private List<Order> orders;
	private SessionMap<String,Object> sessionMap;
	
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap<String, Object>)map;  
	}  
	
	public String execute()
	{
		
		Application app=Application.getInstance();
		    HotelDetail hdetail=new ArrayList<HotelDetail>(app.getHotelList().values()).get(sno);
			orders=new ArrayList<Order>(app.getHotelCurrentOrders(hdetail.getHotelId()).values());
			sessionMap.put("hdetail",hdetail );
			sessionMap.put("orders",orders );
		
		return "success";
		
	}

	

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	
	
}
