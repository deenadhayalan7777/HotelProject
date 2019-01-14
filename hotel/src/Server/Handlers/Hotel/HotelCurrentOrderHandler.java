package Server.Handlers.Hotel;

import java.io.IOException;
import java.util.Map;
import Server.Handlers.Handler;
import hotel.*;

import com.google.gson.Gson;


public class HotelCurrentOrderHandler extends Handler {

	@Override
	public String doService(Map<String, Object> parameters) {
		
		Integer hotelId= Integer.parseInt((String) parameters.get("hotelId")) ;
        Gson gson=new Gson();
        String response=gson.toJson(app.getHotelCurrentOrders(hotelId));
        return response;
	}

	

}
