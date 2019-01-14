package Server.Handlers.User;

import java.util.Map;
import Server.Handlers.Handler;
import hotel.*;

import com.google.gson.Gson;

import Helper.C;

public class RateOrderHandler extends Handler{

	@Override
	public String doService(Map<String, Object> parameters) {
		
		String response="0";
		Gson g = new Gson(); 
		
	    String jsonItem=(String) parameters.get("order");
		Order order =  g.fromJson(jsonItem, Order.class);
		
		int orderId=order.getOrderId();
		
		 app.setOrderStatus(orderId, C.RATED);
		 app.setOrderRating(orderId, order.getRating());
		 app.calculateRating(order.getHotelId());
		return response;
	}

}
