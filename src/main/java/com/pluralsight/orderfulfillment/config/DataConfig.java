package com.pluralsight.orderfulfillment.config;

import java.util.*;

import javax.inject.*;
import javax.persistence.*;
import javax.sql.*;

import org.apache.commons.dbcp.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.orm.hibernate4.*;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;

/**
 * Data configuration for repositories.
 * 
 * @author Michael Hoffman
 * 
 */
@Configuration
@EnableJpaRepositories(basePackages = { "com.pluralsight.orderfulfillment" })
@EnableTransactionManagement
public class DataConfig {

   @Inject
   private Environment environment;

   @Bean
   public DataSource dataSource() {
      BasicDataSource dataSource = new BasicDataSource();
      dataSource.setDriverClassName(environment.getProperty("db.driver"));
      dataSource.setUrl(environment.getProperty("db.url"));
      dataSource.setUsername(environment.getProperty("db.user"));
      dataSource.setPassword(environment.getProperty("db.password"));
      return dataSource;
   }

   @Bean
   public EntityManagerFactory entityManagerFactory() {
      final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
      jpaVendorAdapter.setDatabasePlatform(environment.getProperty("hibernate.dialect"));
      jpaVendorAdapter.setShowSql(false);
      final Map<String, String> jpaProperties = new HashMap<String, String>();
      jpaProperties.put("hibernate.jdbc.batch_size",
            environment.getProperty("hibernate.jdbc.batch_size"));
      jpaProperties.put("hibernate.default_schema",
            environment.getProperty("hibernate.default_schema"));
      LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setPackagesToScan("com.pluralsight.orderfulfillment");
      factory.setJpaVendorAdapter(jpaVendorAdapter);
      factory.setDataSource(dataSource());
      factory.setJpaPropertyMap(jpaProperties);
      factory.afterPropertiesSet();
      return factory.getObject();
   }

   @Bean
   public PlatformTransactionManager transactionManager() {
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory());
      return transactionManager;
   }

   @Bean
   public HibernateExceptionTranslator hibernateExceptionTranslator() {
      return new HibernateExceptionTranslator();
   }

}
