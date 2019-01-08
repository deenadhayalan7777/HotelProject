package Server.Handlers.Agent;

import java.util.Map;

import hotel.*;
import com.google.gson.Gson;

import Helper.C;
import Server.Handlers.Handler;

public class AgentDeliverHandler extends Handler{

	@Override
	public String doService(Map<String, Object> parameters) {
		
		String response="0";
		Integer agentId=Integer.parseInt((String) parameters.get("agentId"));
		Agent agent=app.getAgent(agentId);
		Integer code=Integer.parseInt((String) parameters.get("code"));
		
		
		if(code==1)
		{
			Integer count=Integer.parseInt((String) parameters.get("count"));
			
			
			if(agent.getCurrentOrders().size()+count<=C.ORDER_LIMIT )
			{
				Integer hotelId=Integer.parseInt((String) parameters.get("hotelId"));
				Hotel hotel=app.getHotel(hotelId);
				synchronized(this)
			    {   if(hotel.getCurrentOrders().size()>=count)	
						{for(Order order:hotel.getCurrentOrders().values())
							{   
									order.setAgentId(agentId);
									order.setStatus(2);
									hotel.getCurrentOrders().remove(order.getOrderId());
									hotel.getOrders().put(order.getOrderId(), order);
									agent.getCurrentOrders().put(order.getOrderId(), order);
									
							}
						}
			    	else
			    		return "-1";
			    } 
			    return "1";
			}
		
		}
		else
		{	Integer orderId=Integer.parseInt((String) parameters.get("orderId"));
		    Order order=app.getOrder(orderId);
			synchronized(this)
			{order.setStatus(3);
		    agent.getCurrentOrders().remove(orderId);
		    agent.getMyOrders().put(orderId, order);
			}
		   
		  
		}
		
		
        return response;
	}

}
