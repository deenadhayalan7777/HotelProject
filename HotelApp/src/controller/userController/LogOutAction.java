package controller.userController;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LogOutAction extends ActionSupport  {


	public String execute() 
	{
		
		       HttpSession session=ServletActionContext.getRequest().getSession();
		       session.setAttribute("user", null);
		       
		    
			  return "success";
	 	
	}

}
