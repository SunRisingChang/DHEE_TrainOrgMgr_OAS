package com.dhee.interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginAI extends AbstractInterceptor{
	private HttpServletResponse response;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map session = invocation.getInvocationContext().getSession();
		response=ServletActionContext.getResponse();
		String isLogin = (String) session.get("nowName");
		String type=(String) session.get("type");
		if (isLogin != null && type.equals("0")) {
			return invocation.invoke();
		} else {
			response.getWriter().print("110");
			return null;
		}
	}

}
