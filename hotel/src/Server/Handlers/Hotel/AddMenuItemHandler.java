package Server.Handlers.Hotel;
import java.util.Map;
import Server.Handlers.Handler;
import hotel.*;

import hotel.*;

import com.google.gson.Gson;

public class AddMenuItemHandler extends Handler {

	@Override
	public String doService(Map<String,Object> parameters) {
		
		String response="0";
		Gson g = new Gson(); 
		Integer hotelId=Integer.parseInt((String) parameters.get("hotelId"));
		Integer code=Integer.parseInt((String) parameters.get("code"));
		if(code==2)
		{
			Integer itemId=Integer.parseInt((String) parameters.get("itemId"));
			app.removeItem(itemId);
		}
		else
		{		
		String jsonItem=(String) parameters.get("item");
		Item item =  g.fromJson(jsonItem, Item.class);
		item.setItemId(app.getItemId()+1);
		app.addItem(item,hotelId);
		}
		response ="1";
        return response;
		}

	
}
