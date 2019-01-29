package controller.hotelController;

import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import hotel.Application;
import hotel.Hotel;




public class SignUpAction extends ActionSupport implements ModelDriven<Hotel> {

	private Hotel hotel;
	private int x,y;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
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
	    if(hotel.getUsername()=="")  
	        addFieldError("username","Name can't be blank");  
	    if(hotel.getPassword()=="")  
	        addFieldError("password","Password must be greater than 5"); 
	    if(hotel.getPhone()=="")  
	        addFieldError("phone","PhoneNo  can't be blank");  
	    if(x>100||x<0)  
	        addFieldError("x","Enter x within 0 to 100");  
	    if(y<0||y>100)  
	        addFieldError("y","Enter y within 0 to 100");  
	    if(!hotel.getUsername().matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		Application app=Application.getInstance();
		int hotelId=app.hotelSignUp(hotel.getUsername(), hotel.getPassword(), hotel.getPhone(),x,y);
		
		if(hotelId>0)
		{	
			Hotel hotel=app.getHotel(hotelId);
			 ServletActionContext.getRequest().getSession().setAttribute("hotel", hotel);
		return "success";
		}
		
		return "failure";
	}

}
