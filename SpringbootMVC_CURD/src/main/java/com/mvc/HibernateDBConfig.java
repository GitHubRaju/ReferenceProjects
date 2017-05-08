package com.mvc;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateDBConfig {
	
	@Autowired
	private Environment env;

	/**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("db.driver"));
	    dataSource.setUrl(env.getProperty("db.url"));
	    dataSource.setUsername(env.getProperty("db.username"));
	    dataSource.setPassword(env.getProperty("db.password"));
	    return dataSource;
	  }
	  /**
		 * Initialize hibernate properties
		 * 
		 * @return Properties
		 */
		/*private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put(AvailableSettings.DIALECT, env.getRequiredProperty("hibernate.dialect"));
			properties.put(AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql"));
			//properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, env.getRequiredProperty("hibernate.batch.size"));
			properties.put(AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto"));
			//properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getRequiredProperty("hibernate.current.session.context.class"));
			return properties;
		}*/
	  
	  private Properties getHibernateProperties()
	  {
		  Properties additionalProperties = new Properties();
		    additionalProperties.put(
		        "hibernate.dialect", 
		        env.getProperty("hibernate.dialect"));
		    additionalProperties.put(
		        "hibernate.show_sql", 
		        env.getProperty("hibernate.show_sql"));
		    additionalProperties.put(
		        "hibernate.hbm2ddl.auto", 
		        env.getProperty("hibernate.hbm2ddl.auto"));
		   return additionalProperties;
	  }
	    @Bean
	    public HibernateTemplate hibernateTemplate() {
	    	HibernateTemplate hibernateTemp= new HibernateTemplate(sessionFactory());
	    	hibernateTemp.setCheckWriteOperations(false);
	    	return hibernateTemp;
	    }

	    @Bean
	    public SessionFactory sessionFactory(){
	        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource());
	        sessionFactoryBuilder.scanPackages("com.mvc.model");
	        sessionFactoryBuilder.addProperties(getHibernateProperties());
	        return sessionFactoryBuilder.buildSessionFactory();
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager() {
	        return new HibernateTransactionManager(sessionFactory());
	    }
		
	/*	@Bean
		public LocalSessionFactoryBean getSessionFactory() {
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(dataSource());
			sessionFactory.setPackagesToScan("com.mvc.model" );
			sessionFactory.setHibernateProperties(getHibernateProperties());
			return sessionFactory;
		}


		*//**
		 * Initialize Transaction Manager
		 * 
		 * @param sessionFactory
		 * @return HibernateTransactionManager
		 *//*
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager txManager = new HibernateTransactionManager();
			txManager.setSessionFactory(sessionFactory);
			return txManager;
		}*/
}
