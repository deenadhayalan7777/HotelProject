package controller.agentController;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


import hotel.Agent;
import hotel.Application;


public class SignUpAction extends ActionSupport implements ModelDriven<Agent> {

	private Agent agent;
	private int x;
	private int y;
	
	
	

	public Agent getModel(){  
	    agent=new Agent();  
	    return agent;  
	}
	
	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(agent.getUsername()==null)  
	        addFieldError("username","Name can't be blank");  
	    if(agent.getPassword()==null)  
	        addFieldError("password","Password must be greater than 5"); 
	    if(agent.getPhone()==null)  
	        addFieldError("phone","Phone No can't be blank");  
	    if(x>100||x<0)  
	        addFieldError("x","Enter x within 0 to 100");  
	    if(y<0||y>100)  
	        addFieldError("y","Enter y within 0 to 100");  
	   if(!agent.getUsername().matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		Application app=Application.getInstance();
		int agentId=app.agentSignUp(agent.getUsername(), agent.getPassword(), agent.getPhone(),x,y);
		
		if(agentId>0)
		return "success";
		
		return "failure";
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

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

}
