package controller.hotelController;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import hotel.Application;
import hotel.Hotel;




public class SignUpAction extends ActionSupport implements ModelDriven<Hotel> {

	private Hotel hotel;
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Hotel getModel(){  
	    hotel=new Hotel();  
	    return hotel;  
	}
	
	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(hotel.getUsername()==null)  
	        addFieldError("username","Name can't be blank");  
	    if(hotel.getPassword()==null)  
	        addFieldError("password","Password must be greater than 5"); 
	    if(hotel.getPhone()==null)  
	        addFieldError("phone","PhoneNo  can't be blank");  
	    if(!hotel.getUsername().matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		Application app=Application.getInstance();
		int hotelId=app.hotelSignUp(hotel.getUsername(), hotel.getPassword(), hotel.getPhone());
		
		if(hotelId>0)
		return "success";
		
		return "failure";
	}

}
