package Server.Handlers.User;


import java.util.Map;
import Server.Handlers.Handler;


import com.google.gson.Gson;


public class ViewMenuHandler extends Handler  {

	@Override
	public String doService(Map<String,Object> parameters) {
		int hotelId= Integer.parseInt((String) parameters.get("hotelId")) ;
        Gson gson=new Gson();
       String response=gson.toJson(app.getHotelMenu(hotelId));
       return response;
	}
}
