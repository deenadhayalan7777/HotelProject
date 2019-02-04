package controller.agentController;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.C;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Item;
import hotel.Order;


public class SelectHotelAction extends ActionSupport {

	private int sno;
	private int size;
	
	public String execute()
	{
		
		Application app=Application.getInstance();
		    HotelDetail hdetail=new ArrayList<HotelDetail>(app.getHotelList().values()).get(sno);
		    size=0;
		    Map<Integer,Order> orders=app.getHotelCurrentOrders(hdetail.getHotelId());
			for(Order order:orders.values())
			{
				if(order.getStatus()==C.ACCEPTED && order.getTimer()==0)
				{
					size++;
				}
			
			}
			
		
		return "success";
		
	}

	

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}

	
	
}
