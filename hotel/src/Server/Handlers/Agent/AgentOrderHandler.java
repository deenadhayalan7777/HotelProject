package Server.Handlers.Agent;

import java.util.Map;

import Helper.C;
import Server.Handlers.Handler;
import hotel.*;



public class AgentOrderHandler extends Handler {

	@Override
	public String doService(Map<String, Object> parameters) {
		
		Integer agentId= Integer.parseInt((String) parameters.get("agentId")) ;
		Integer code= Integer.parseInt((String) parameters.get("code")) ;
		Agent agent=app.getAgent(agentId);
		String response=null;
		if(code==C.CURRENT_ORDERS)
		{
			response=gson.toJson(agent.getCurrentOrders());
		}
		else
          response=gson.toJson(agent.getMyOrders());
        
		return response;
		
		
	}

}
