package controller.hotelController;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;






public class LogOutAction extends ActionSupport  {

	
	
	public String execute() 
	{
		
		    
			  ServletActionContext.getRequest().getSession().invalidate();
		     
			  return "success";
	 	
		
	}

	

}
