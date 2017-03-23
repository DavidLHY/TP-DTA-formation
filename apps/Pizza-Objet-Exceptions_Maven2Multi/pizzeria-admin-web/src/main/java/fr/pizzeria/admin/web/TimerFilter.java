package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/pizzas/*")
public class TimerFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();

		String path = ((HttpServletRequest) req).getRequestURI();

		HttpServletRequest request = (HttpServletRequest) req;

		Integer nbSession = (Integer) request.getSession().getServletContext().getAttribute("compteur");
		
		List<String> cheminReq = (List<String>) request.getSession().getServletContext().getAttribute("cheminReq");
		List<Long> tempsReq = (List<Long>) request.getSession().getServletContext().getAttribute("tempsReq");

		if (cheminReq == null) {
			cheminReq = new ArrayList<String>();
		}
		if (tempsReq == null) {
			tempsReq = new ArrayList<Long>();
		}
		tempsReq.add((after - before));
		cheminReq.add(request.getRequestURI());

		request.getSession().getServletContext().setAttribute("cheminReq", cheminReq);
		request.getSession().getServletContext().setAttribute("tempsReq", tempsReq);
		request.getSession().getServletContext().setAttribute("nbSession", nbSession);

	}

	@Override
	public void destroy() {
	}
}