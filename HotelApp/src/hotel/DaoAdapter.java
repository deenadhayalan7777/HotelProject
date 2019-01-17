package hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import hotel.Agent;
import hotel.Hotel;
import hotel.HotelDetail;
import hotel.Item;
import hotel.ItemQuantity;
import hotel.Order;
import hotel.User;

public class DaoAdapter {

	private static DaoAdapter db=null;
	private Dao dao;
	
	private DaoAdapter()
	{
		dao=Dao.getInstance();
	}
	
	public static DaoAdapter getInstance()
	{
		if(db==null)
			db=new DaoAdapter();
		return db;
	}
	
	public void setHotel(Hotel hotel)  
	{
       try {
		dao.setHotel(hotel.getHotelId(),hotel.getUsername(),hotel.getPassword(),hotel.getPhone(),hotel.getRating());
	       } catch (SQLException e) {System.out.println(e);}
	}
   
	
  public Hotel getHotel(String username)
  { 
	  
	    try {
	    	ResultSet rs=dao.getHotel(username);
			while(rs.next())  
			 {  
				int hotelId=rs.getInt(1);
				String password=rs.getString(3);
				String phone=rs.getString(4);
				Hotel hotel=new Hotel(hotelId,username,password,phone);
				return hotel;
			}
		} catch (SQLException e) {System.out.println(e);}
	 return null;
  }
  
  public Hotel getHotel(int hotelId)
  { 
	  
	    try {
	    	ResultSet rs=dao.getHotel(hotelId);
			while(rs.next())  
			 {  
				String username=rs.getString(2);
				String password=rs.getString(3);
				String phone=rs.getString(4);
				Hotel hotel=new Hotel(hotelId,username,password,phone);
				return hotel;
			}
		} catch (SQLException e) {System.out.println(e);}
	 return null;
  }
  
  public void setUser(User user )  
	{
	  try {
			dao.setUser(user.getUserId(), user.getUsername(), user.getPassword(),user.getPhone());
	      } catch (SQLException e) {System.out.println(e);}
	}
  public User getUser(String username)
  { 
	  
	    try {
	    	ResultSet rs=dao.getUser(username);
			while(rs.next())  
			 {
				int userId=rs.getInt(1);
				String password=rs.getString(3);
				String phone=rs.getString(4);
				User user=new User(userId,username,password,phone);
				
				return user;
			 }
		   } catch (SQLException e) {System.out.println(e);}
	 return null;
  }
  
  public User getUser(int userId)
  { 
	  
	    try {
	    	ResultSet rs=dao.getUser(userId);
			while(rs.next())  
			 {
				String username=rs.getString(2);
				String password=rs.getString(3);
				String phone=rs.getString(4);
				User user=new User(userId,username,password,phone);
				
				return user;
			 }
		   } catch (SQLException e) {System.out.println(e);}
	 return null;
  }
  
  public void setAgent(Agent agent ) 
	{
	  try {
			dao.setAgent(agent.getAgentId(),agent.getUsername() , agent.getPassword(), agent.getPhone());
	      } catch (SQLException e) {System.out.println(e);}
	}
public Agent getAgent(String username)
{ 
	    try {
	    	ResultSet rs=dao.getAgent(username);
	    	while(rs.next())
	    	{int agentId=rs.getInt(1);
			String password=rs.getString(3);
			String phone=rs.getString(4);
			Agent agent=new Agent(agentId,username,password,phone);
			
			return agent;
	    	}
		} catch (SQLException e) {System.out.println(e);}
	 return null;
}
public Agent getAgent(int agentId)
{ 
	    try {
	    	ResultSet rs=dao.getAgent(agentId);
	    	while(rs.next())
	    	{String username=rs.getString(2);
			String password=rs.getString(3);
			String phone=rs.getString(4);
			Agent agent=new Agent(agentId,username,password,phone);
			
			return agent;
	    	}
		} catch (SQLException e) {System.out.println(e);}
	 return null;
}  
 
  
 public int getLastId(int code) 
   {
	   int count=0;
	   ResultSet rs = null;
	   switch(code)
	   {
	   case C.HOTEL:rs=dao.getLastHotelId();break;
	   case C.USER: rs=dao.getLastUserId();break;
	   case C.AGENT:rs=dao.getLastAgentId();break;
	   case C.ORDER:rs=dao.getLastOrderId();break;
	   }
	   
	    try {
			while(rs.next())  
			count= rs.getInt(1);
		} catch (SQLException e) {System.out.println(e);}
	 return count;
   
   }
   public int getLastItemId() 
   {
	   int count=0;
	   ResultSet rs=dao.getLastItemId();
	    try {
			while(rs.next())  
			count= rs.getInt(1);
		} catch (SQLException e) {System.out.println(e);}
	 return count;
   
   }
  
   public int getId(int code,int orderId) 
   {
	   int count=0;
	   ResultSet rs = null;
	   
	   
	    try {
	    	switch(code)
	 	   {
	 	   case C.HOTEL:rs=dao.getHotelId(orderId);break;
	 	   case C.USER: rs=dao.getUserId(orderId);break;
	 	   case C.AGENT:rs=dao.getAgentId(orderId);break;
	 	   
	 	   }
	    	while(rs.next())  
			count= rs.getInt(1);
		} catch (SQLException e) {System.out.println(e);}
	 return count;
   
   }
   
   public void addOrder(Order order)
   {
	   try {
		   System.out.println("In adapter add order");
		   
		   DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
		   String strDate = dateFormat.format(order.getDate());
		dao.setOrder(order.getOrderId(), order.getTotal(), order.getDiscount(),order.getRating(), strDate, order.getStatus());
		dao.addUserOrder(order.getUserId(), order.getOrderId());
		dao.addHotelOrder(order.getHotelId(), order.getOrderId());
		for(ItemQuantity item:order.getItemsList())
		{
			dao.addOrderItems(order.getOrderId(), item.getItemId(),item.getQuantity());
		}
	} catch (SQLException e) { System.out.println(e);}
   }
   
   public Order getOrder(int orderId)
   {
	      Order order=null;
		  
		try {
			  ResultSet rs=dao.getOrder(orderId);
			  while(rs.next())
			  {int total=rs.getInt(2);
			  int discount = rs.getInt(3);
			 int rating=rs.getInt(4);
			  int hotelId = getId(C.HOTEL,orderId);
			  int agentId=getId(C.AGENT,orderId);
			  int userId=getId(C.USER,orderId);
			  String phoneNo = getUser(userId).getPhone();
			  SimpleDateFormat ft = new SimpleDateFormat ("YYYY-MM-dd HH:mm:ss");
			  Date date=ft.parse(rs.getString(5));
			  int status=rs.getInt(6);
			 
			  List<ItemQuantity> items=new ArrayList<ItemQuantity>();
			  rs=dao.getItemQuantity(orderId);
			  while(rs.next())
			  {
				  int subtotal=rs.getInt(2)*rs.getInt(4);
				  ItemQuantity iq=new ItemQuantity(rs.getInt(1),rs.getInt(2),subtotal,rs.getString(3),rs.getInt(4));
				  items.add(iq);
			  }
			  
			  
			   order=new Order(orderId,items,total,phoneNo,discount,hotelId,userId);
			  order.setDate(date);
			  order.setRating(rating);
			  order.setStatus(status);
			  order.setAgentId(agentId);
			  }
		} catch (SQLException | ParseException e) {
			
			e.printStackTrace();
		}
	return order;	  
   }
   public void  addAgentOrder(int agentId,int orderId)
   {
	   try {
		dao.addAgentOrder(agentId, orderId);
	  } catch (SQLException e) {
		
		e.printStackTrace();
	  }
   }
   public void setHotelRating(int hotelId,float rating)
   {
	   dao.setHotelRating(hotelId, rating);
   }
   
   public void setHotelStatus(int hotelId,int status)
   {
	   dao.setHotelStatus(hotelId, status);
   }
   public Map<Integer,HotelDetail> getHotelList()
   {
	   Map<Integer,HotelDetail> hotellist=new HashMap<Integer,HotelDetail>();
	   try {
		   ResultSet rs=dao.getHotels();
			while(rs.next())  
			{ boolean status=true;
			  if(rs.getInt(6)==0)
				  status=false;
			  HotelDetail hdetail=new HotelDetail(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(5),status);
			 hotellist.put(hdetail.getHotelId(), hdetail);
			}
			
		} catch (SQLException e) {System.out.println(e);}
	   return hotellist;
   }
   
   public void addItem(Item item,int hotelId)
   {
	   try {
		dao.setItem(item.getItemId(),item.getName(),item.getPrice());
		dao.setHotelMenu(hotelId, item.getItemId());
	    } catch (SQLException e) {System.out.println(e);}   
   
   }
   public void removeItem(int itemId)
   {
	   dao.removeItem(itemId);
   }
   
   public Map<Integer,Order> getOrders(int code,int id)
   {
	   Map<Integer,Order> orders=new HashMap<Integer,Order>();
	   try {
		   ResultSet rs = null;
		   switch(code)
	 	   {
	 	   case C.HOTEL:rs=dao.getHotelOrders(id);break;
	 	   case C.USER: rs=dao.getUserOrders(id);break;
	 	   case C.AGENT:rs=dao.getAgentOrders(id);break;
	 	   
	 	   }
			while(rs.next())  
			{ 
			  Order order=getOrder(rs.getInt(1));	
			  orders.put(order.getOrderId(), order);
			
			}
			
		} catch (SQLException e) {System.out.println(e);} 
	   
	   
	   return orders;
   }
   
   public Map<Integer,Order> getCurrentOrders(int code,int id)
   {
	   Map<Integer,Order> orders=new HashMap<Integer,Order>();
	   try {
		   ResultSet rs = null;
		   switch(code)
	 	   {
	 	   case C.HOTEL:rs=dao.getHotelCurrentOrders(id);break;
	 	   case C.USER: rs=dao.getUserCurrentOrders(id);break;
	 	   case C.AGENT:rs=dao.getAgentCurrentOrders(id);break;
	 	   
	 	   }
			while(rs.next())  
			{ 
			  Order order=getOrder(rs.getInt(1));	
			  orders.put(order.getOrderId(), order);
			
			}
			
		} catch (SQLException e) {System.out.println(e);} 
	  
	   return orders;
   }
   
   public void setOrderStatus(int orderId,int status)
   {
	   dao.setOrderStatus(orderId, status);
   }
   
   public void setOrderRating(int orderId,int rating )
   {
	   dao.setOrderRating(orderId, rating);
   }
   
   public HotelDetail getHotelDetail(int hotelId)
   {
	   try {
		   ResultSet rs=dao.getHotelDetail(hotelId);
			while(rs.next())  
			{ boolean status=true;
			  if(rs.getInt(6)==0)
				  status=false;
			  return new HotelDetail(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(5),status);
			 
			}
			
		} catch (SQLException e) {System.out.println(e);}
	   return null;
   }

   public Map<Integer,Item> getHotelMenu(int hotelId)
   {
	   Map<Integer,Item> menu=new HashMap<Integer,Item>();
	   try {
			    ResultSet rs=dao.getHotelMenu(hotelId);
				while(rs.next())  
				{ 
				  Item item=new Item(rs.getInt(1),rs.getString(2),rs.getInt(3));
				 menu.put(item.getItemId(), item);
				}
			
		   } catch (SQLException e) {System.out.println(e);}
	   
	   
	   return menu;
   }
	
}