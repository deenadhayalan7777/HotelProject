package Server.Handlers.Agent;

import java.util.Map;




import Helper.C;
import Server.Handlers.Handler;
import hotel.*;

public class AgentDeliverHandler extends Handler{

	@Override
	public String doService(Map<String, Object> parameters) {
		
		String response="0";
		Integer agentId=Integer.parseInt((String) parameters.get("agentId"));
		Integer code=Integer.parseInt((String) parameters.get("code"));
		if(code==1)
		{
			Integer count=Integer.parseInt((String) parameters.get("count"));
			
			
			if(app.getAgentCurrentOrders(agentId).size()+count<=C.ORDER_LIMIT )
			{
				Integer hotelId=Integer.parseInt((String) parameters.get("hotelId"));
				synchronized(this)
			
			    { 
					Map<Integer,Order> hotelOrders=app.getHotelCurrentOrders(hotelId);
					if(hotelOrders.size()>=count)	
						{for(Order order:hotelOrders.values())
							{   
									app.addAgentOrder(agentId, order.getOrderId());
									app.setOrderStatus(order.getOrderId(), C.ASSIGNED);
							
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
		    
			synchronized(this)
			{
				app.setOrderStatus(orderId, C.DELIVERED);
			}
		   
		  
		}
		
		
        return response;
	}

}
