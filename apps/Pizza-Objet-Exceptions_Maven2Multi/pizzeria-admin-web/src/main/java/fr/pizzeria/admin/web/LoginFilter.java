package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/pizzas/*" , "/logout" , "/technique"})
public class LoginFilter implements Filter {

	private FilterConfig config=null;
	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		this.config= config;
		this.config.getServletContext().log("coucou");
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Object user = httpRequest.getSession().getAttribute("user");
		
		if(user == null) {
			
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");		
		} else {
			this.config.getServletContext().log("bien identifier");
			chain.doFilter(request, response);			
		}
		
		
		
		
	}

	
	
	public void destroy() {	}

}
