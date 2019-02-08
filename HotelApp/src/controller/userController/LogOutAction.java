package controller.userController;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class LogOutAction extends ActionSupport  {


	public String execute() 
	{
		
		       HttpSession session=ServletActionContext.getRequest().getSession();
		       session.setAttribute("user", null);
		       
		       if(session.getAttribute("user")==null && session.getAttribute("agent")==null && session.getAttribute("hotel")==null)
			    session.invalidate();
		     
			  return "success";
	 	
	}

}
