package Server.Handlers.User;

import java.io.IOException;
import java.util.Map;


import Server.Handlers.Handler;


public class MyOrderHandler extends Handler{
	
	@Override
	public String doService(Map<String,Object> parameters) {
		
		Integer userId= Integer.parseInt((String) parameters.get("userId")) ;
		Integer code= Integer.parseInt((String) parameters.get("code")) ;
		String response=null;
		if(code==1)
			response=gson.toJson(app.getUser(userId).getCurrentOrders());
		else
         response=gson.toJson(app.getUser(userId).getMyOrders());
        return response;
	}


}