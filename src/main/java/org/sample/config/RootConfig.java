package org.sample.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.sample.example.h2.Employee;
import org.sample.service.AgeValidator;
import org.sample.service.AgeValidatorImpl;
import org.sample.service.EmailMessage;
import org.sample.service.FileValidator;
import org.sample.service.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample")
@EnableScheduling
public class RootConfig {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);
	
	 @Bean
	    public ViewResolver viewResolver() {
		 InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		 irvr.setPrefix("/WEB-INF/");
		 irvr.setSuffix(".jsp");
		 return irvr;
	    }
	 
	 @Bean
	 public Message message(){
		 return new EmailMessage();
	 }

	 @Bean
	 public AgeValidator validator(){
		 return new AgeValidatorImpl();
	 }
	 
	 @Bean //Spring scheduler
	 public ThreadPoolTaskScheduler cts(){
		 return new ThreadPoolTaskScheduler();
	 }
	
	 @Bean // File upload
	 public CommonsMultipartResolver multipartResolver(){
		 return new CommonsMultipartResolver();
	 }
	 
	 // Hibernate datasource
	 @Bean
	 public DataSource getDataSource(){
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("org.h2.Driver");
		 dataSource.setUrl("jdbc:h2:mem:test");
		 dataSource.setUsername("sa");
		 dataSource.setPassword("");
		 return dataSource;
	 }
	 
	 // Hibernate Sessionfactory
	 @Bean
	 @DependsOn("getDataSource")
	 public SessionFactory sessionFactory() throws SQLException{
		 LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		 sessionFactoryBuilder.addAnnotatedClasses(Employee.class);
		 SessionFactory factory = sessionFactoryBuilder.buildSessionFactory();
			/*String db = ((SessionImplementor)factory).getJdbcConnectionAccess().obtainConnection()
				       .getMetaData().getDatabaseProductName();
					 LOGGER.info("sessionFactory detal "+db);*/
		 return factory;
		/* return new LocalSessionFactoryBuilder(getDataSource())
		   .addAnnotatedClasses(Employee.class)
		   .buildSessionFactory();*/
		 
	 }
	 
	 // Hibernate template
	 @Bean
	 @DependsOn("sessionFactory")
	 public HibernateTemplate hibernateTemplate() throws SQLException{
		 HibernateTemplate template = new HibernateTemplate(sessionFactory());
		/*String db = ((SessionImplementor) template.getSessionFactory()).getJdbcConnectionAccess().obtainConnection()
	       .getMetaData().getDatabaseProductName();*/
		 LOGGER.info("Template detal "+template.getSessionFactory().getStatistics());
		 return template;
	 }
	 
	 @Bean
		public HibernateTransactionManager hibTransMan() throws SQLException{
			return new HibernateTransactionManager(sessionFactory());
		}
}
