package hotel;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;



public class Application {
	
	
	private static Application app=null;
	
	DaoAdapter db;
	
	private Application()
	{
		 db=DaoAdapter.getInstance();
		
		
	}
	
	public static Application getInstance()
	{
		if(app==null)
			app=new Application();
		return app;
	}
	
	public int userLogin(String username,String password)
	{
		int userId=0;
		User user=db.getUser(username);
		 
		 if(user!=null)
		 {
			 if(user.getPassword().equals(cryptWithMD5(password)))
				 userId= user.getUserId();
			 else
				 userId=-1;
		 }
		
		 return userId;
	}
	public int userSignUp(String username,String password,String phone)
	{   
		User user=db.getUser(username);
		int userId=-2;
		if(user==null)
		{synchronized(this){
			int userCount=getUserCount()+1;
			db.setUser(new User(userCount,username,cryptWithMD5(password),phone));
			userId=userCount;
			userCount++;
		    }
		}
		
		return userId;
	}
	public int agentLogin(String username,String password)
	{
		int agentId=0;
		Agent agent=db.getAgent(username);
		 
		 if(agent!=null)
		 {
			 if(agent.getPassword().equals(cryptWithMD5(password)))
				 agentId= agent.getAgentId();
			 else
				 agentId=-1;
		 }
		return agentId;
	}
	public int agentSignUp(String username,String password,String phone)
	{   
		Agent agent=db.getAgent(username);
		int agentId=-2;
		if(agent==null)
		{
			synchronized(this){
				int agentCount=getAgentCount()+1;
			db.setAgent(new Agent(agentCount,username,cryptWithMD5(password),phone));
			agentId=agentCount;
			agentCount++;
		    }
		
		
		}
		return agentId;
	}
	public int hotelLogin(String username,String password)
	{
		int hotelId=0;
		Hotel hotel=db.getHotel(username);
		 
		 if(hotel!=null)
		 {
			 if(hotel.getPassword().equals(cryptWithMD5(password)))
				 hotelId= hotel.getHotelId();
			 else
				 hotelId=-1;
		 }
		return hotelId;
	}
	public int hotelSignUp(String username,String password,String phone)
	{
		Hotel hotel=db.getHotel(username);
		int hotelId=-2;
		if(hotel==null)
		{synchronized(this){
			int hotelCount=getHotelCount()+1;
			db.setHotel(new Hotel(hotelCount,username,cryptWithMD5(password),phone));
			hotelId=hotelCount;
			hotelCount++;
		    }
		}
		
		return hotelId;
	}
	public int getOrderCount()
	{
		return db.getLastId(C.ORDER);
	}
	public int getHotelCount()
	{
		return db.getLastId(C.HOTEL);
	}
	
	public int getUserCount()
	{
		return db.getLastId(C.USER);
	}
	
	public int getAgentCount()
	{
		return db.getLastId(C.AGENT);
	}
	public Map<Integer,HotelDetail> getHotelList()
	{
		
		return db.getHotelList();
		
	}
	public User getUser(int userId) {
		return db.getUser(userId);
		
	}
	public Hotel getHotel(int hotelId) {
		
	 return db.getHotel(hotelId);
	}
	public void addOrder(Order order)
	{
		HotelDetail hdetail=getHotelDetail(order.getHotelId());
		order.setHotelname(hdetail.getUsername());
		db.addOrder(order);
	}
	public Order getOrder(int orderId) {
		
		 return db.getOrder(orderId);
		}
	public Agent getAgent(int agentId)
	{
		
		return db.getAgent(agentId);
	}
	public HotelDetail getHotelDetail(int hotelId)
	{
		return db.getHotelDetail(hotelId);
	}
	
	
	 public void addItem(Item item,int hotelId)
	   {
		   db.addItem(item,hotelId);
	   }
	 public void removeItem(int itemId)
	 {
		 db.removeItem(itemId);
	 }
	public int getItemId()
	{
		return db.getLastItemId();
	}
	
	public Map<Integer,Item> getHotelMenu(int hotelId)
	{
		
		return db.getHotelMenu(hotelId);
	}
	public void addAgentOrder(int agentId,int orderId)
	{
		db.addAgentOrder(agentId, orderId);
	}
	public void setHotelStatus(int hotelId,int status)
	{
		db.setHotelStatus(hotelId, status);
	}
	
	public void setOrderStatus(int orderId,int status)
	{
		db.setOrderStatus(orderId, status);
	}
	public void setOrderRating(int orderId,int rating)
	{
		db.setOrderRating(orderId, rating);
		Order order=getOrder(orderId);
		calculateRating(order.getHotelId());
	}
	public Map<Integer,Order> getHotelOrders(int hotelId)
	{
			return db.getOrders(C.HOTEL,hotelId);
	}
	public Map<Integer,Order> getHotelCurrentOrders(int hotelId)
	{
			return db.getCurrentOrders(C.HOTEL,hotelId);
	}
	public Map<Integer,Order> getUserOrders(int userId)
	{
			return db.getOrders(C.USER,userId);
	}
	public Map<Integer,Order> getUserCurrentOrders(int userId)
	{
			return db.getCurrentOrders(C.USER,userId);
	}
	public Map<Integer,Order> getAgentOrders(int agentId)
	{
			return db.getOrders(C.AGENT,agentId);
	}
	public Map<Integer,Order> getAgentCurrentOrders(int agentId)
	{
			return db.getCurrentOrders(C.AGENT,agentId);
	}
	
	public void calculateRating(int hotelId)
	{
		float totalRating=0;
		int numberOfRatings=0;
		for(Order order:getHotelOrders(hotelId).values())
		{
			if(order.getRating()!=0)
			{
				numberOfRatings++;
				totalRating+=order.getRating();
			}
		}
		if(numberOfRatings!=0)
		{totalRating=(totalRating/numberOfRatings);
		db.setHotelRating(hotelId, totalRating);
		}
	}
     public static String cryptWithMD5(String text){
		
		StringBuffer sb = new StringBuffer();
		 
	        byte[] digested;
			try {
				digested = MessageDigest.getInstance("MD5").digest(text.getBytes());
				 sb = new StringBuffer();
		        for(int i=0;i<digested.length;i++){
		            sb.append(Integer.toHexString(0xff & digested[i]));
		        }
		        
			} catch (NoSuchAlgorithmException e) {
				
			}  
	        
			return sb.toString();


	   }

	public void setItemStock(int itemId, int stock) {
		db.setItemStock(itemId,stock);
		
	}
	
}
