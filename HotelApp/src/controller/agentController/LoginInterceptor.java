package controller.agentController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import controller.userController.SignUpAction;

public class LoginInterceptor extends AbstractInterceptor implements
		StrutsStatics {

	

	public String intercept(ActionInvocation invocation) throws Exception {

		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(HTTP_REQUEST);
		HttpSession session = request.getSession(true);
        System.out.println(invocation.getAction().getClass());
		
		Object agent = session.getAttribute("agent");
		if (agent == null) {
			
			if (invocation.getAction().getClass().equals(LoginAction.class)||invocation.getInvocationContext().getName().equals("signup")||invocation.getAction().getClass().equals(SignUpAction.class))
			{
				return invocation.invoke();
			}
			return "login";
		} else {
			return invocation.invoke();
		}
	}

}
