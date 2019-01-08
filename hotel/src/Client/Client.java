package Client;
import Helper.ServerAccess;
import Helper.InputHandler;
import Helper.*;
import hotel.*;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;




public class Client {
	
	
	public boolean isLogged;
	public int id;
	private Gson gson;
	public ServerAccess server;
	
	
	public Client()
	{
		gson=new Gson();
		server=ServerAccess.getInstance();
		
	}
	
	
	
	public void loginToServer(String context)
	{
		InputHandler in=new InputHandler();
		id=0;
		while(id<=0)
		{	
		System.out.println("1.Login 2.SignUp");
		int c=in.getIntegerInput(1,2);
		if(c==1)
			{
			  System.out.println("Enter username ");
			  String username=in.getStringInput();
			  System.out.println("Enter password ");
			  String password=in.getStringInput();
			 id=login(username, Service.cryptWithMD5(password),context);
			}
		else
		{
			  System.out.println("Enter username ");
			  String username=in.getStringInput();
			  System.out.println("Enter password ");
			  String password=in.getStringInput();
			  System.out.println("Enter phone Number");
			  String phone=in.getStringInput();
			  id=signUp(username, Service.cryptWithMD5(password), phone,context);
			
		}
		if(id>0)
			isLogged=true;
		else if(id==0)
			System.out.println("Invalid Username");
		else if(id==-1)
			System.out.println("Invalid Password");
		else
			System.out.println("Username Already exists");
		}
		 
	}
	public int login(String username,String password,String context)
	{
		return server.login(username, password, context);
		
	}
	
	public int signUp(String username,String password,String phone,String context)
	{
		return server.signUp(username, password, phone, context);
	}
	
	
	public void addItem(Item item,int hotelId)
	{
		server.addItem(item,hotelId);
        
	}
	public void removeItem(int itemId,int hotelId)
	{
		server.removeItem(itemId,hotelId);
        
	}
	
	public Map<Integer,Item> getMenu(int hotelId)
	{
		return server.getMenu(hotelId);
	}
	
	public Discount getDiscount(int hotelId)
	{
		return server.getDiscount(hotelId);
		
	}
	
	public HotelDetail getHotelDetail(int hotelId)
	{
		return server.getHotelDetail(hotelId);
		
	}
	public void setHotelStatus(int hotelId,int status)
	{
		server.setHotelStatus(hotelId, status);
       
		
	}
	
	public Map<Integer,HotelDetail> getHotelList()
	{
		return server.getHotelList();
	}
	
	
	
	public void makeOrder(int hotelId,List<ItemQuantity> items,int total,int discount,int rating)
	{
		server.makeOrder(hotelId,id, items, total, discount, rating);
	}
	
	
	  public Map<Integer,Order> getHotelCurrentOrders(int hotelId)
			{
				return server.getHotelCurrentOrders(hotelId);
			}
	 	
	  public void setDiscountTime(int timePercentage,int toTime,int fromTime)
	  {
		  server.setDiscountTime(id, timePercentage, toTime, fromTime);
	  }
	  public void setDiscountTotal(int totalPercentage,int baseTotal)	
	  {
		  server.setDiscountTotal(id, totalPercentage, baseTotal);
	  }
	  public void setDiscountItem(int itemPercentage,int itemId,int count)
	  {
		  server.setDiscountItem(id, itemPercentage, itemId, count);
	  }
	  public void setDiscountMembership(int memberPercentage,int point)
	  {
		  server.setDiscountMembership(id, memberPercentage, point);
	  }
}
	

