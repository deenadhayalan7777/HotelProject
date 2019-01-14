package Server.Handlers.Hotel;

import java.util.Map;
import Server.Handlers.Handler;
import hotel.*;

import com.google.gson.Gson;

public class HotelDetailHandler extends Handler {

	@Override
	public String doService(Map<String, Object> parameters) {
		
		int hotelId= Integer.parseInt((String) parameters.get("hotelId")) ;
		int code= Integer.parseInt((String) parameters.get("code")) ;
		if(code==2)
		 {int status= Integer.parseInt((String) parameters.get("status")) ;
		  app.setHotelStatus(hotelId, status);
		  return "1";
		 }
		Gson gson=new Gson();
		
		HotelDetail hdetail=app.getHotelList().get(hotelId);
		  String response=gson.toJson(hdetail);
		  System.out.println(response);
		  return response;
		
		
	}

}
