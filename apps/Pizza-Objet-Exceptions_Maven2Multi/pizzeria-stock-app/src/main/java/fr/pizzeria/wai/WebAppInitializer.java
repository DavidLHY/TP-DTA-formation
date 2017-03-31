package fr.pizzeria.wai;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import fr.pizzeria.config.StockConfig;
import fr.pizzeria.dao.config.DaoSpringDataJPAConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOG = Logger.getLogger(WebAppInitializer.class.getName());
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		LOG.log(Level.INFO, "demarrage du serveur");
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(StockConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		
		dispatcher.addMapping("/mvc/*");
		
		
		servletContext.addListener(new ContextLoaderListener(webContext));
		
		
	}



}
