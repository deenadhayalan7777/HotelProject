package Server.Handlers.Hotel;

import java.util.Map;
import Server.Handlers.Handler;


public class HotelSignUpHandler extends Handler{

	
	@Override
	public String doService(Map<String,Object> parameters) {
		
		
        String username=(String) parameters.get("username");
          String password=(String) parameters.get("password");
      
      
       	            String phone=(String) parameters.get("phone");
       	            Integer userId=app.hotelSignUp(username, password, phone);
       	            System.out.println("hotel signed up "+userId);
       	            
        
        
        
        return userId.toString();
	}

}
