package controller.userController;


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

public class SelectHotelAction extends ActionSupport implements SessionAware{

	private int sno;
	private List<Item> menu;
	private SessionMap<String,Object> sessionMap;
	
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap<String, Object>)map;  
	}  
	
	public String execute()
	{
		
		Application app=Application.getInstance();
		    HotelDetail hdetail=new ArrayList<HotelDetail>(app.getHotelList().values()).get(sno);
			menu=new ArrayList<Item>(app.getHotelMenu(hdetail.getHotelId()).values());
			sessionMap.put("hdetail",hdetail );
			sessionMap.put("menu",menu );
		
		return "success";
		
	}

	public List<Item> getMenu() {
		return menu;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	
	
}
