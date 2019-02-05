package controller.agentController;



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


import hotel.Agent;
import hotel.Application;


public class SignUpAction extends ActionSupport implements ModelDriven<Agent> {

	private Agent agent;
	
	
	
	



	public Agent getModel(){  
	    agent=new Agent();  
	    return agent;  
	}
	
	public void validate() { 
		String regex="[A-Za-z0-9]+";
	    if(agent.getUsername()=="")  
	        addFieldError("username","Name can't be blank");  
	    if(agent.getPassword()=="")  
	        addFieldError("password","Password must be greater than 5"); 
	    if(agent.getPhone()=="")  
	        addFieldError("phone","Phone No can't be blank");  
	   
	    if(!agent.getUsername().matches(regex))
	    	 addFieldError("username","Enter Proper Username");  
	}  
	
	
	public String execute() 
	{
		Application app=Application.getInstance();
		int agentId=app.agentSignUp(agent.getUsername(), agent.getPassword(), agent.getPhone());
		
		if(agentId>0)
		{
			
			 Agent agent=app.getAgent(agentId);
			 ServletActionContext.getRequest().getSession().setAttribute("agent", agent);
			 
			return "success";
		}
		
		
		return "failure";
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	



}
