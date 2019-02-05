package hotel;
import java.sql.*;

public class Dao {
	
	java.sql.Connection con;
	private static Dao dao=null;
	
	private Dao() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost/hotel?" +
					 "user=root&password=root1234");
			//con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/hotel","root","root1234");
			System.out.println("Database connection established");
			String query="create table if not exists HOTEL (hotelId int,username varchar(25) unique not null,"
					+ "password varchar(50) not null,phone varchar(10) not null,rating int default 5,status int default 1,placeId int , primary key(hotelId),foreign key(placeId) references places(placeId) on delete set null)";

			Statement stmt = con.createStatement();
		    stmt.execute(query);
		    
		    query="create table if not exists item(itemId int,"
		    		+ "name varchar(25) not null,price int not null,primary key(itemId))";
		    stmt.execute(query);
		    
		    query="create table if not exists hotel_menu(hotelId int,itemId int,time int default 0,stock int default 1,foreign key(hotelId) references hotel(hotelId),foreign key(itemId) references item(itemId))";
		    stmt.execute(query);
		    
		    query="create table if not exists orders (orderId int,total int, "
		    		+ "discount int default 0,rating int default 0,date date,status int, primary key(orderId))";
		    stmt.execute(query);
		    
		    query="create table if not exists order_items(orderId int,itemId int,"
		    		+ "quantity int,foreign key(orderId) references orders(orderId),foreign key(itemId) references item(itemId))";
		    stmt.execute(query);
		    
		    query="create table if not exists hotel_orders(hotelId int,orderId int,"
		    		+ "foreign key(hotelId) references hotel(hotelId),foreign key(orderId) references orders(orderId))";
		    
		    stmt.execute(query);
		    
		    query="create table if not exists user (userId int,username varchar(25) unique not null,"
		    		+ "password varchar(50) not null,phone varchar(10) not null,placeId int , primary key(userId),foreign key(placeId) references places(placeId) on delete set null)";
		    
		    stmt.execute(query);
		    
		    query="create table if not exists user_orders(userId int,orderId int,"
		    		+ "foreign key(userId) references user(userId),foreign key(orderId) references orders(orderId)) ";
		    stmt.execute(query);
		    
		    query="create table if not exists agent(agentId int,username varchar(25) unique not null,"
		    		+ "password varchar(50) not null,phone varchar(10) not null,placeId int,  primary key(agentId),foreign key(placeId) references places(placeId) on delete set null)";
		    stmt.execute(query);
		   
		    query=" create table if not exists agent_orders(agentId int,orderId int,"
		    		+ "foreign key(agentId) references agent(agentId),foreign key(orderId) references orders(orderId))";
		    stmt.execute(query);
		    
		    query="create table if not exists order_time(orderId int,timer int default 0,foreign key(orderId) references orders(orderId))";
		    stmt.execute(query);
		    
		    query="create table if not exists places(placeId int,name varchar(50) unique,x int default 0,y int default 0)";
		    stmt.execute(query);
		    
		    query="create table if not exists path(source int,dest int,foreign key(source) references places(placeId) on delete cascade,foreign key(dest) references places(placeId) on delete cascade)";
		    stmt.execute(query);
		    
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
		
		
	   
	}
	public static Dao getInstance() 
	{
		if(dao==null)
			dao=new Dao();
		return dao;
	}
	
	public void setHotel(int hotelId,String username,String password,String phone,float rating) throws SQLException 
	{
        String query = " insert into hotel(hotelId,username,password,phone,rating)"
			        + " values (?,?,?,?,?)";

			     
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      
			      preparedStmt.setInt(1, hotelId);
			      preparedStmt.setString (2,username);
			      preparedStmt.setString (3,password);
			      preparedStmt.setString (4,phone);
			      preparedStmt.setFloat(5, rating);
			     
			      preparedStmt.execute();

	}
   
	public void removeItem(int itemId)
	{
		 String query = " delete from hotel_menu where itemId=?";
	      
			      try {
			    	  PreparedStatement preparedStmt = con.prepareStatement(query); 
					preparedStmt.setInt(1, itemId);
					 preparedStmt.execute();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			     
			     
	}
	
  public ResultSet getHotel(int hotelId) throws SQLException
  {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select * from hotel where hotelId= "+hotelId);
  }
  
  public void setUser(int userId,String username,String password,String phone) throws SQLException 
	{
      String query = " insert into user(userId,username,password,phone)"
			        + " values (?,?,?,?,?)";

			     
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      
			      preparedStmt.setInt(1, userId);
			      preparedStmt.setString (2,username);
			      preparedStmt.setString (3,password);
			      preparedStmt.setString (4,phone);
			     
	 			  preparedStmt.execute();

	}
  
  public ResultSet getUser(int userId) throws SQLException
  {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select * from user where userId= "+userId);
  }
  
 
  public void setAgent(int agentId,String username,String password,String phone) throws SQLException 
 	{
       String query = " insert into agent(agentId,username,password,phone)"
 			        + " values (?,?,?,?,?)";

 			     
 			      PreparedStatement preparedStmt = con.prepareStatement(query);
 			      
 			      preparedStmt.setInt(1, agentId);
 			      preparedStmt.setString (2,username);
 			      preparedStmt.setString (3,password);
 			      preparedStmt.setString (4,phone);
 			     
 			      preparedStmt.execute();

 	}
   
   public ResultSet getAgent(int agentId) throws SQLException
   {  
 	    Statement stmt=con.createStatement();  
 		return stmt.executeQuery(" select * from agent where agentId= "+ agentId);
   }
   
   public void setOrderStatus(int orderId,int status)
   {
	   String query = " update orders set status=? where orderId=? ";

		     
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, status);
			      preparedStmt.setInt(2, orderId);
			      
			      preparedStmt.execute();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      
   }
   public void setOrderRating(int orderId,int rating)
   {
	   String query = " update orders set rating=? where orderId=? ";

		     
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, rating);
			      preparedStmt.setInt(2, orderId);
			      
			      preparedStmt.execute();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      
   }
   public void setHotelStatus(int hotelId,int status)
   {
	   String query = " update hotel set status=? where hotelId=? ";

		     
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, status);
			      preparedStmt.setInt(2, hotelId);
			      
			      preparedStmt.execute();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      
   }
   public void setHotelRating(int hotelId,float rating)
   {
	   String query = " update hotel set rating=? where hotelId=? ";

		     
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setFloat(1, rating);
			      preparedStmt.setInt(2, hotelId);
			      
			      preparedStmt.execute();

			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		      
   }
   public void setOrder(int orderId,int total,int discount,int rating,String date,int status ) throws SQLException 
	{
      String query = " insert into orders(orderId,total,discount,rating,date,status)"
			        + " values (?,?,?,?,?,?)";

			     
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      
			      preparedStmt.setInt(1, orderId);
			      preparedStmt.setInt(2, total);
			      preparedStmt.setInt(3, discount);
			      preparedStmt.setInt(4, rating);
			      preparedStmt.setString (5,date);
			      preparedStmt.setInt(6, status);
			     
			      preparedStmt.execute();

	}
  
  public ResultSet getOrder(int orderId) throws SQLException
  {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select * from orders where orderId= "+ orderId);
  }
  
  public ResultSet getHotelDetail(int hotelId) throws SQLException
  {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select * from hotel where hotelId= "+ hotelId);
  }
  public void setHotelMenu(int hotelId,int itemId,int time,int stock) throws SQLException
  {
	  String query = " insert into hotel_menu(hotelId,itemId,time,stock)"
		        + " values (?,?,?,?)";

		     
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		     
		      preparedStmt.setInt(1, hotelId);
		      preparedStmt.setInt(2, itemId);
		      preparedStmt.setInt(3, time);
		      preparedStmt.setInt(4, stock);
		      preparedStmt.execute();
	  
  }
  public void setItem(int itemId,String name,int price) throws SQLException
  {
	  String query = " insert into item(itemId,name,price)"
		        + " values (?,?,?)";

		     
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		     
		      preparedStmt.setInt(1, itemId);
		      preparedStmt.setString(2, name);
		      preparedStmt.setInt(3, price);
		      
		      preparedStmt.execute();
	  
  }
  public void addOrderItems(int orderId,int itemId,int quantity) throws SQLException 
  {
	  String query = " insert into order_items(orderId,itemId,quantity)"
		        + " values (?,?,?)";

		     
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		     
		      preparedStmt.setInt(1, orderId);
		      preparedStmt.setInt(2, itemId);
		      preparedStmt.setInt(3, quantity);
		      preparedStmt.execute();
  }
  public void addHotelOrder(int hotelId,int orderId) throws SQLException 
 	{
       String query = " insert into hotel_orders(hotelId,orderId)"
 			        + " values (?,?)";

 			     
 			      PreparedStatement preparedStmt = con.prepareStatement(query);
 			     
 			      preparedStmt.setInt(1, hotelId);
 			      preparedStmt.setInt(2, orderId);
 			      
 			      preparedStmt.execute();

 	}
  
  public void addOrderTime(int orderId,int timer) throws SQLException 
	{
     String query = " insert into order_time(orderId,timer)"
			        + " values (?,?)";
 
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setInt(1, orderId);
			      preparedStmt.setInt(2, timer);
			      preparedStmt.execute();

	}
   
   public ResultSet getHotelOrders(int hotelId) throws SQLException
   {  
 	    Statement stmt=con.createStatement();  
 	   return stmt.executeQuery(" select hotel_orders.orderId "
				+ " from hotel_orders inner join orders on hotel_orders.orderId =orders.orderId where hotelId="+ hotelId+" and status >1  ");
   }
   
   public ResultSet getHotelCurrentOrders(int hotelId) throws SQLException
   {  
 	    Statement stmt=con.createStatement();  
 	   return stmt.executeQuery(" select hotel_orders.orderId "
				+ " from hotel_orders inner join orders on hotel_orders.orderId=orders.orderId where hotelId="+ hotelId+" and status <=1  ");

    }
   
   public void addUserOrder(int userId,int orderId) throws SQLException 
	{
      String query = " insert into user_orders(userId,orderId)"
			        + " values (?,?)";

			     
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			     
			      preparedStmt.setInt(1, userId);
			      preparedStmt.setInt(2, orderId);
			      
			      preparedStmt.execute();

	}
  
  public ResultSet getUserOrders(int userId) throws SQLException
  {  
	    Statement stmt=con.createStatement(); 
	    return stmt.executeQuery(" select orders.orderId "
				+ " from user_orders inner join orders on user_orders.orderId=orders.orderId where userId="+ userId+" and status >2 ");

  }
  
  public ResultSet getUserCurrentOrders(int userId) throws SQLException
  {  
	    Statement stmt=con.createStatement();
	    return stmt.executeQuery(" select orders.orderId from user_orders inner join orders on user_orders.orderId=orders.orderId where userId="+ userId+" and status <=2  ");
	    	
  }
  
  public void addAgentOrder(int agentId,int orderId) throws SQLException 
	{
     String query = " insert into agent_orders(agentId,orderId)"
			        + " values (?,?)";

			     
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			     
			      preparedStmt.setInt(1, agentId);
			      preparedStmt.setInt(2, orderId);
			      
			      preparedStmt.execute();

	}
 
 public ResultSet getAgentOrders(int agentId) throws SQLException
 {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select agent_orders.orderId from agent_orders inner join orders on agent_orders.orderId=orders.orderId WHERE agentId="+ agentId+" and status >=2 ");
 }
 
 public ResultSet getAgentCurrentOrders(int agentId) throws SQLException
 {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select agent_orders.orderId "
				+ " from agent_orders inner join orders on agent_orders.orderId =orders.orderId where agentId="+ agentId+" and status =2  ");
 }
   
 public ResultSet getHotelMenu(int hotelId) throws SQLException
 {  
	    Statement stmt=con.createStatement();  
		return stmt.executeQuery(" select item.itemId, item.name,item.price,hotel_menu.time,hotel_menu.stock from hotel_menu INNER JOIN item"
				+ " ON hotel_menu.hotelId="+ hotelId+" and hotel_menu.itemId=item.itemId");
 }
 public ResultSet getLastHotelId() 
 {
	   ResultSet rs = null;
		 try {
			Statement stmt = con.createStatement();
			rs= stmt.executeQuery("select max(hotelId) from hotel");   
			} catch (SQLException e) {}
		                            
	  	 return rs;	
	 }
 
 public ResultSet getLastUserId() 
 {
	   ResultSet rs = null;
		 try {
			Statement stmt = con.createStatement();
			rs= stmt.executeQuery("select max(userId) from user");   
			} catch (SQLException e) {}
		                            
	  	 return rs;	
	 }
 
 public ResultSet getLastAgentId() 
 {
	   ResultSet rs = null;
		 try {
			Statement stmt = con.createStatement();
			rs= stmt.executeQuery("select max(agentId) from agent");   
			} catch (SQLException e) {}
		                            
	  	 return rs;	
	 }
 
   
   public ResultSet getLastOrderId() 
   {
	   ResultSet rs = null;
		 try {
			Statement stmt = con.createStatement();
			rs= stmt.executeQuery("select max(orderId) from orders");   
			} catch (SQLException e) {}
		                            
	  	 return rs;	
	 }
   
   public ResultSet getLastItemId() 
   {
	   ResultSet rs = null;
		 try {
			Statement stmt = con.createStatement();
			rs= stmt.executeQuery("select max(ItemId) from item");   
			} catch (SQLException e) {}
		                            
	  	 return rs;	
   }

   public ResultSet getHotel(String username) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select * from hotel where username= '" + username+"'");
  	 
   }
   public ResultSet getOrderTime(int orderId) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select * from order_time where orderId="+orderId);
  	 
   }
   public ResultSet getUser(String username) throws SQLException 
   {
  	
	
		Statement stmt = con.createStatement();
		return stmt.executeQuery("select * from user where username= '" + username+"'");
  	    
   }
   
   public ResultSet getAgent(String username) throws SQLException 
   {
  	
	
		Statement stmt = con.createStatement();
	    return stmt.executeQuery("select * from agent where username= '" + username+"'");
  	    
   }
  
   
   public ResultSet getHotels() throws SQLException 
   {
  	
	
		Statement stmt = con.createStatement();
	    return stmt.executeQuery("select * from hotel ");
  	    
   }
   public ResultSet getItemQuantity(int orderId) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select order_items.itemId,order_items.quantity,item.name,item.price from order_items inner join item on order_items.itemId=item.itemId where orderId= " + orderId);
  	 
   }
   
   public ResultSet getHotelId(int orderId) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select hotelId from hotel_orders where orderId= " + orderId);
  	 
   }
   public ResultSet getUserId(int orderId) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select userId from user_orders where orderId= " + orderId);
  	 
   }
   public ResultSet getAgentId(int orderId) throws SQLException 
   {
  	    
	   Statement stmt = con.createStatement();
		return stmt.executeQuery("select agentId from agent_orders where agentId= " + orderId);
  	 
   }
public void setItemStock(int itemId, int stock) {
	
	String query = " update hotel_menu set stock=? where itemId=? ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, stock);
	      preparedStmt.setInt(2, itemId);
	      
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}
  
public void setUserLocation(int userId,int placeId) {
	
	String query = " update user set placeId=? where userId=?; ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, placeId);
	      preparedStmt.setInt(2, userId);
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}
   

public void setAgentLocation(int agentId,int placeId) {
	
	String query = " update agent set placeId=? where agentId=?; ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1,placeId );
	      preparedStmt.setInt(2, agentId); 
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void setHotelLocation(int hotelId,int placeId) {
	
	String query = " update hotel set placeId=? where hotelId=?";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1,placeId );
	      preparedStmt.setInt(2, hotelId); 
	      System.out.println("Hotel Location Setted");
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void setOrderTimer(int orderId,int timer) {
	
	String query = " update order_time set timer=? where orderId=?; ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, timer);
	      preparedStmt.setInt(2, orderId);
	     
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void setOrderDate(int orderId,String date) {
	
	String query = " update orders set date=? where orderId=?; ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1, date);
	      preparedStmt.setInt(2, orderId);
	     
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public ResultSet getPaths() throws SQLException {
	Statement stmt = con.createStatement();
	return stmt.executeQuery("select * from path");
	 
}

public ResultSet getLocations() throws SQLException {
	Statement stmt = con.createStatement();
	return stmt.executeQuery("select * from places");
	 
}

public ResultSet getLocation(int placeId) throws SQLException {
	Statement stmt = con.createStatement();
	return stmt.executeQuery("select * from places where placeId="+placeId);
	 
}

public ResultSet getLocation(String placeName) throws SQLException {
	Statement stmt = con.createStatement();
	return stmt.executeQuery("select * from places where name='"+placeName+"'");
	 
}

public void deleteLocations() {
	
	String query = " delete from places ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		  preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void setAllHotelLocation() {
	
	String query = " update hotel set placeId=1 where hotelId>0 ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		  preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}


public void deletePaths() {
	
	String query = " truncate table path ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		  preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void addLocation(int id, String name,int x,int y) {
	
	String query = " insert into places values (?,?,?,?) ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		 preparedStmt.setInt(1, id);
		preparedStmt.setString(2, name);
	      preparedStmt.setInt(3, x);
	      preparedStmt.setInt(4, y);
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}

public void addPath(int source,int dest) {
	
	String query = " insert into path values (?,?) ";

    
    PreparedStatement preparedStmt;
	try {
		preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, source);
	      preparedStmt.setInt(2, dest);
	     
	      preparedStmt.execute();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}
    
}
public ResultSet getAllUsersCurrentOrders() throws SQLException {
	 Statement stmt=con.createStatement();
	   return stmt.executeQuery(" select orders.orderId from user_orders inner join orders on user_orders.orderId=orders.orderId where status <=2  ");
	   
}

public ResultSet getDestinations(int source) throws SQLException
{
	 Statement stmt=con.createStatement();
	   return stmt.executeQuery(" select dest from path where source="+source);
}

public ResultSet getSources(int dest) throws SQLException
{
	 Statement stmt=con.createStatement();
	 return stmt.executeQuery(" select source from path where dest="+dest);
 
}


}
