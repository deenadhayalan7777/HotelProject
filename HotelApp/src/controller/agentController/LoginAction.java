package controller.agentController;



import com.opensymphony.xwork2.ActionSupport;


import hotel.Application;

public class LoginAction extends ActionSupport {

	
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	 
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		 Integer  agentId=app.agentLogin(username, password);
		 if(agentId>0)
		 {
			 return "success";
		 }
		
		return "failure";
	}
	
	 
	


	
	
}