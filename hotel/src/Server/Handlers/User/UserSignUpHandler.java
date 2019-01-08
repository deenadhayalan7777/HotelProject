package Server.Handlers.User;


import java.util.Map;
import Server.Handlers.Handler;


public class UserSignUpHandler extends Handler  {

	

	@Override
	public String doService(Map<String,Object> parameters) {
		
		 String username=(String) parameters.get("username");
         String password=(String) parameters.get("password");
                  String phone=(String) parameters.get("phone");
       	       Integer  userId=app.userSignUp(username, password, phone);
       	            System.out.println("user signed up "+userId);
       	            
       	        String response=userId.toString(); 
       	        return response;
        
         }
        
       
		
	}
	


	
