package hotel;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;



public class Application {
	
	
	private static Application app=null;
	private Map<Integer,Order> currentOrders;
	DaoAdapter db;
	
	public Map<Integer, Order> getCurrentOrders() {
		return currentOrders;
	}

	private Application()
	{
		 db=DaoAdapter.getInstance();
		 currentOrders=getAllUsersCurrentOrders();
		 startTimer();
		 populateLocations();
		 populatePaths();
		
	}
	
	
	private Map<Integer, Order> getAllUsersCurrentOrders() {
		
		return db.getAllUsersCurrentOrders();
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
	public int userSignUp(String username,String password,String phone, int locationId)
	{   
		User user=db.getUser(username);
		int userId=-2;
		if(user==null)
		{synchronized(this){
			int userCount=getUserCount()+1;
			db.setUser(new User(userCount,username,cryptWithMD5(password),phone));
			setUserLocation(userId,locationId);
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
	public int agentSignUp(String username,String password,String phone,int locationId)
	{   
		Agent agent=db.getAgent(username);
		int agentId=-2;
		if(agent==null)
		{
			synchronized(this){
				int agentCount=getAgentCount()+1;
			db.setAgent(new Agent(agentCount,username,cryptWithMD5(password),phone));
			setAgentLocation(agentId, locationId);
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
	public int hotelSignUp(String username,String password,String phone,int locationId)
	{
		Hotel hotel=db.getHotel(username);
		int hotelId=-2;
		if(hotel==null)
		{synchronized(this){
			int hotelCount=getHotelCount()+1;
			db.setHotel(new Hotel(hotelCount,username,cryptWithMD5(password),phone));
			setHotelLocation(hotelId,locationId);
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

	public void setHotelLocation(int hotelId, int locationId) {
		db.setLocation(C.HOTEL,hotelId,locationId);
		
	}
	public void setUserLocation(int userId, int locationId) {
		db.setLocation(C.USER,userId,locationId);
		
	}

	public void setAgentLocation( int agentId, int locationId) {
		db.setLocation(C.AGENT,agentId,locationId);
	}
	
	public Map<Integer,Location> getLocations()
	{
		return db.getLocations();
		
	}
	
	public List<String> getLocationNames()
	{
		List<String> locations=new ArrayList<String>();
		for(Location location:getLocations().values())
			locations.add(location.getName());
		return locations;
		
	}
	public Location getLocation(int id)
	{
		return db.getLocation(id);
	}
	public void setOrderDate(int orderId, Date date) {
		db.setOrderDate(orderId, date);
		
	}

	public void setOrderTimer(int orderId) {
		
		Order order=getOrder(orderId);
		
		if(order.getStatus()==C.ACCEPTED)
		{ Map<Integer,Item> menu=getHotelMenu(order.getHotelId());
			int max=0;
			for(ItemQuantity item:order.getItemsList())
			{
				int time=menu.get(item.getItemId()).getTime();
				if(max<time)
				{
					max=time;
				}
			}
	      db.setOrderTimer(orderId,max);
		}
		
		if(order.getStatus()==C.ASSIGNED)
		{
			Location hotelLocation=getHotel(order.getHotelId()).getLocation();
			int deliverTime=getUser(order.getUserId()).getLocation().getDistance(hotelLocation);
			db.setOrderTimer(orderId, deliverTime);
			
		}
		
	}
	
	public void startTimer()
	{
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		       @Override
		       public void run() {
		          for(Order order:currentOrders.values())
		          {
		        	  if(order.getTimer()!=0)
		        	  {  
		        		  int timer=order.getTimer()-1;
		        		  order.setTimer(timer);
		        		  db.setOrderTimer(order.getOrderId(),timer);
		        	  }
		          }
		       }
		    }, 0, 10000);
	}
	
private void populatePaths() {
		
	
		String fileName=System.getProperty("catalina.base")+C.pathFile;
		System.out.println(fileName);
		String pathText=getStringFromFile(fileName);
		if(pathText!=null)
		{   
			db.deletePaths();
			String[] paths = pathText.split(",");
			for(String path:paths)
			{
				String[] p=path.split(" ");
				int source=Integer.parseInt(p[0]);
				int dest=Integer.parseInt(p[1]);
				db.addPath(source, dest);
			}
		}

	}

	private String getStringFromFile(String fileName) {
		
		String text="";
		try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		    String line;
		    while ((line = br.readLine()) != null) 
              text+=line; 
            br.close();

		   } catch (IOException e) {
		    System.out.println("ERROR: unable to read file " + fileName);
		    e.printStackTrace();   
		    }
		return text;
	}

	private void populateLocations() {
		
		String fileName=System.getProperty("catalina.base")+C.placeFile;
		System.out.println(fileName);
		String placeText=getStringFromFile(fileName);
		if(placeText!=null)
		{   
			db.deleteLocations();
			String[] places = placeText.split(",");
			for(String place:places)
			{
				String[] p=place.split(" ");
				String name=p[0];
				int x=Integer.parseInt(p[1]);
				int y=Integer.parseInt(p[2]);
				db.addLocation(name, x, y);
			}
		}

		
	}

	
}
