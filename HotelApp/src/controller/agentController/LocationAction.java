package controller.agentController;





import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hotel.Agent;
import hotel.Application;

import hotel.Location;


public class LocationAction extends ActionSupport {

	private int id;
	
	public String execute() 
	{
		
		Application app=Application.getInstance();
		HttpSession session=ServletActionContext.getRequest().getSession(); 
		Agent agent=(Agent) session.getAttribute("agent");
		Location loc=app.getLocation(id);
		if(loc==null)
			System.out.println("Location null");
		else
		{ app.setAgentLocation(agent.getAgentId(), loc.getLocationId());
		  agent.setLocation(loc);
		 }
	    return "success";
		
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	

	
	 
	


	
	
}
