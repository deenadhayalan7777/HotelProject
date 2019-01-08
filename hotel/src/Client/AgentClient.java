package Client;

import java.util.ArrayList;
import hotel.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

import Helper.*;


public class AgentClient extends Client {
	
	private static InputHandler input;
	
	
	public Map<Integer,Order> getMyOrders(int agentId)
	{
		return server.getAgentOrders(agentId);
	}	
	
	public Map<Integer,Order> getCurrentOrders(int agentId)
	{
		return server.getAgentCurrentOrders(agentId);
	}
	
	public int assignOrder(int hotelId,int count)
	{
		
		return server.assignOrder(id,hotelId,count);
	}
	
	public void deliverOrder(int orderId)
	{
		server.deliverOrder(id,orderId);
	}
	
public static void main(String[] args) {
		
	    input=new InputHandler();
		AgentClient agentClient=new AgentClient();
        Service service=Service.getInstance();
		agentClient.loginToServer("agent");
		
		if(agentClient.isLogged)
		{
			System.out.println("1.PickupOrders 2.MyOrders 3.CurrentOrders 4.DeliverOrder 5.Exit");
			int agentId=agentClient.id;
			System.out.println("Agent Id is "+agentClient.id);
			int choice=input.getIntegerInput(1, 5);
			while(choice<5)
			{switch(choice)
			 {
			  case C.HOTELS:{
				            
				             Map<Integer,HotelDetail> map = agentClient.getHotelList();
				             service.displayHotelList(map);
				             
				             System.out.println("Enter hotel Id");
				             int hotelId=input.getIntegerInput();
				             System.out.println("1.Pickup Orders 2. Leave hotel and back");
				             int ch=input.getIntegerInput(1,2);
				             switch(ch)
				             {
				           
				             case 1:{        
				            	        Map<Integer,Order> orders = agentClient.getHotelCurrentOrders(hotelId);
				            	        
				            	        System.out.println("Available orders in hotel "+orders.size() );
				            	        if(orders.size()>0)
				            	        { System.out.println("Enter number of orders to pickup");
				            	        
				            	        int count=input.getIntegerInput(1,orders.size());
				            	        
				            	        	int limit=agentClient.assignOrder(hotelId,count);
				            	        	 if(limit==0)
				            	        	 {
				            	        		 System.out.println("Your order limit is less than count" );
				            	        	 } 
				            	        	 else if(limit<0)
				            	        	 {
				            	        		 System.out.println(" ");
				            	        	 }
				            	        	 else
				            	        		 System.out.println("Orders picked up"); 
				            	        	}
				            	        	
				            	        		break;
				            	        }
				            	      
				             case C.LEAVE_AND_BACK:{
				            	                    break;
				                                   }
				             }
				             break;
			               }
			 case C.MYORDERS:{
									 Map<Integer,Order> ordersmap = agentClient.getMyOrders(agentId);
						             List<Order> orders=new ArrayList<Order>(ordersmap.values());
						             service.displayOrders(orders);
						             if(orders.size()>0)
						             {System.out.println("Enter SNO to view the order 0 to back");
						             int i=input.getIntegerInput(0,orders.size());
						         
						             while(i!=0)
						             {
						            	 Order order=orders.get(i-1);
						            	 service.viewOrder( order, agentClient.getHotelList());
						            	 System.out.println("Enter SNO to view the order 0 to back");
							              i=input.getIntegerInput(0,orders.size());
						             }
						             }
						             break;
				                 
			                 }
			 case C.CURR_ORDERS:{
									 Map<Integer,Order> ordersmap = agentClient.getCurrentOrders(agentId);
						             List<Order> orders=new ArrayList<Order>(ordersmap.values());
						             service.displayOrders(orders);
						             if(orders.size()>0)
						             {System.out.println("Enter SNO to view the order 0 to back");
						             int i=input.getIntegerInput(0,orders.size());
						         
						             while(i!=0)
						             {
						            	 Order order=orders.get(i-1);
						            	 
						            	 service.viewOrder( order, agentClient.getHotelList());
						            	 System.out.println("Enter SNO to view the order 0 to back");
							              i=input.getIntegerInput(0,orders.size());
						             }}
	                               break;
             
                     }
			 case C .DELIVERY:{
				                int i=1;
				                 do {
								 Map<Integer,Order> ordersmap = agentClient.getCurrentOrders(agentId);
					             List<Order> orders=new ArrayList<Order>(ordersmap.values());
					             service.displayOrders(orders);
					             if(orders.size()>0)
					             {System.out.println("Enter SNO to deliver the order 0 to back");
					                i=input.getIntegerInput(0,orders.size());
					                if(i!=0)
					                { Order order=orders.get(i-1);
					            	agentClient.deliverOrder(order.getOrderId()); 
					            	System.out.println(" Order is delivered ");
					                } 
					             }
					             else
					            	 i=0;
					             }while(i!=0);
				                 
				                 break;
			        }
			}
			System.out.println("1.PickupOrders 2.MyOrders 3.CurrentOrders 4.DeliverOrder 5.Exit");
			choice=input.getIntegerInput(1, 5);
		}
	 }
		
	}
}
