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

import hotel.Agent;
import hotel.Application;
import hotel.Hotel;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Location;
import hotel.Order;
import hotel.User;

public class MapAction extends ActionSupport{

	
	private String placeJson;
	private String pathJson;
	private String agentJson;
	private String hotelJson;
	private String userJson;
	private int orderId;

	
	public String getPlaceJson() {
		return placeJson;
	}


	public void setPlaceJson(String placeJson) {
		this.placeJson = placeJson;
	}


	public String getPathJson() {
		return pathJson;
	}


	public void setPathJson(String pathJson) {
		this.pathJson = pathJson;
	}


	public String getAgentJson() {
		return agentJson;
	}


	public void setAgentJson(String agentJson) {
		this.agentJson = agentJson;
	}


	public String getHotelJson() {
		return hotelJson;
	}


	public void setHotelJson(String hotelJson) {
		this.hotelJson = hotelJson;
	}


	public String getUserJson() {
		return userJson;
	}


	public void setUserJson(String userJson) {
		this.userJson = userJson;
	}


	public String execute()
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		User user=(User) session.getAttribute("user");
		Gson gson = new Gson();
		Order order=app.getOrder(orderId);
		Hotel hotel=app.getHotel(order.getHotelId());
		Location agentLocation=app.getAgentCurrentLocation(orderId);
		agentLocation.setName(order.getAgentname());
		agentJson=gson.toJson(agentLocation);
		
		userJson=gson.toJson(new Location(1, user.getUsername(),user.getLocation().getX(),user.getLocation().getY()));
		hotelJson=gson.toJson(new Location(1, hotel.getUsername(),hotel.getLocation().getX(),hotel.getLocation().getY()));
		  
		placeJson=gson.toJson(new ArrayList<Location>(app.getLocations().values()));
		pathJson=gson.toJson(app.getPaths());
		
		System.out.println(agentJson);
		
		return "success";
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
