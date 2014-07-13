package com.pluralsight.orderfulfillment.config;

import javax.servlet.*;

import org.springframework.web.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;

/**
 * Initializes the web application in place of a descriptor.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class WebContextInitializer implements WebApplicationInitializer {

   @Override
   public void onStartup(ServletContext servletContext) throws ServletException {
      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
      rootContext.register(Application.class);
      rootContext.setServletContext(servletContext);
      ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
            new DispatcherServlet(rootContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
   }

}
