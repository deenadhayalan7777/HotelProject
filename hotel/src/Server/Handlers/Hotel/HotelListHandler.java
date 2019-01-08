package Server.Handlers.Hotel;

import java.util.Map;
import Server.Handlers.Handler;





import com.google.gson.Gson;

public class HotelListHandler extends Handler{

	@Override
	public String doService(Map<String,Object> parameters) {
		
		Gson gson=new Gson();
		
	  String response=gson.toJson(app.getHotelList());
	  return response;
	}

	
}
