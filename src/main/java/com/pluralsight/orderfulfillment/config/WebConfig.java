package com.pluralsight.orderfulfillment.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;
import org.springframework.web.servlet.view.tiles2.*;

/**
 * Web configuration
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Configuration
@ComponentScan("com.pluralsight.orderfulfillment")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

   @Bean
   public ViewResolver viewResolver() {
      UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
      viewResolver.setViewClass(TilesView.class);
      return viewResolver;
   }

   /**
    * Configures Tiles at application startup.
    */
   @Bean
   public TilesConfigurer tilesConfigurer() {
      TilesConfigurer configurer = new TilesConfigurer();
      configurer.setDefinitions(new String[] { "/WEB-INF/jsp/tiles.xml" });
      configurer.setCheckRefresh(true);
      return configurer;
   }

   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }

}
