package controller.agentController;




import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;

import hotel.Location;



public class LocationAction extends ActionSupport {

	private String location;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Agent agent=(Agent) session.getAttribute("agent");
		Location loc=app.getLocation(location);
		app.setAgentLocation(agent.getAgentId(), loc.getLocationId());
		agent.setLocation(loc);
	    return "success";
		
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	
	 
	


	
	
}
