package controller.userController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

import hotel.Application;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Order;
import hotel.User;

public class OrderAction extends ActionSupport{

	private int hotelId;
	private int total;
	private String itemslist;
	
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public String getItemslist() {
		return itemslist;
	}


	public void setItemslist(String itemslist) {
		this.itemslist = itemslist;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String execute()
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		User user=(User) session.getAttribute("user");
		Gson gson = new Gson();
		System.out.println(itemslist);
		List<ItemQuantity> items=gson.fromJson(itemslist, new TypeToken<ArrayList<ItemQuantity>>(){}.getType());
		
		
		Order order=new Order(app.getOrderCount()+1, items,  total,user.getPhone(),0,hotelId, user.getUserId());
		app.addOrder(order);
		
		return "success";
	}
}
