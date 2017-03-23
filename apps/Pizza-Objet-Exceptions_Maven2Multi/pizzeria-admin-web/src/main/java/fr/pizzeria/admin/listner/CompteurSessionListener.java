package fr.pizzeria.admin.listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CompteurSessionListener implements HttpSessionListener {

   
   
	
    @Override
    public void sessionCreated(HttpSessionEvent event) {

    	
    Integer compteur = (Integer) event.getSession().getServletContext().getAttribute("compteur");
    if(compteur==null){
    	compteur=0;
    }
    event.getSession().getServletContext().setAttribute("compteur", compteur + 1);
    System.out.println(" Ouverture session");
    System.out.println("Nombre de sessions ouvertes = " + (compteur + 1));
    	
    System.out.println("Session Created:: ID="+event.getSession().getId());
    }
	
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	
    	Integer compteur = (Integer) event.getSession().getServletContext().getAttribute("compteur");
        if(compteur==null){
        	compteur=0;
        }
        event.getSession().getServletContext().setAttribute("compteur", Math.max(0,compteur - 1));
        System.out.println(" Fermeture session");
        System.out.println("Nombre de sessions ouvertes = " + Math.max(0,compteur - 1));
        	
        System.out.println("Session Created:: ID="+event.getSession().getId());
        
    	
    }
	
}
