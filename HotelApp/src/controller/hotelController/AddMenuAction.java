package controller.hotelController;

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
import hotel.Hotel;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Order;
import hotel.User;

public class AddMenuAction extends ActionSupport{

	
	private String itemslist;
	
	
	public String getItemslist() {
		return itemslist;
	}


	public void setItemslist(String itemslist) {
		this.itemslist = itemslist;
	}


	


	public String execute()
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Hotel hotel=(Hotel) session.getAttribute("hotel");
		int hotelId=hotel.getHotelId();
		Gson gson = new Gson();
		Item item=gson.fromJson(itemslist, Item.class);
		item.setItemId(app.getItemId()+1);
		app.addItem(item, hotelId);
		
		return "success";
	}
}
