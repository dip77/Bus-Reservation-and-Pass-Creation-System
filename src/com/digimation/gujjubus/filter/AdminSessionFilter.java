package com.digimation.gujjubus.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digimation.gujjubus.bean.AdminBean;
import com.digimation.gujjubus.bean.UserBean;
public class AdminSessionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
    	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    		System.out.println("filter");
    		HttpServletRequest req=(HttpServletRequest)request;
    		HttpServletResponse res=(HttpServletResponse)response;
    		HttpSession session=req.getSession();
    			AdminBean adminBean=(AdminBean)session.getAttribute("AdminBean");
    		if(adminBean==null)
    		{
    			req.setAttribute("msglogin", "please login to continue");
    			req.getRequestDispatcher("UserLoginPage.jsp").forward(req, res);
    		}
    		else
    		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
