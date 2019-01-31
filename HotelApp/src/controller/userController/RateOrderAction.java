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
import hotel.C;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Order;
import hotel.User;

public class RateOrderAction extends ActionSupport{

	private int orderId;
	private int rating;
	

	


	public String execute()
	{
		
		Application app=Application.getInstance();
		
		
		app.setOrderRating(orderId, rating);
		app.setOrderStatus(orderId, C.RATED);
		
		return "success";
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}
}
