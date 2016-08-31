package org.sample.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.sample.hibernate.Employee;
import org.sample.hibernate.EmployeeDao;
import org.sample.hibernate.IEmployeeDao;
import org.sample.service.AgeValidator;
import org.sample.service.AgeValidatorImpl;
import org.sample.service.EmailMessage;
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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sample")
@EnableScheduling
@EnableTransactionManagement
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
	 
	 @Bean
	 public  IEmployeeDao employeeDao() {
		 return new EmployeeDao();
	 }
	 
	 // Hibernate datasource
	 @Bean
	 public DataSource getDataSource(){
		 BasicDataSource dataSource = new BasicDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		 dataSource.setUsername("root");
		 dataSource.setPassword("");
		 return dataSource;
	 }
	 
	 // Hibernate Sessionfactory
	 @Bean
	 @DependsOn("getDataSource")
	 public SessionFactory sessionFactory() throws SQLException{
		return new LocalSessionFactoryBuilder(getDataSource()).
		 addAnnotatedClasses(Employee.class).buildSessionFactory();
	 }
	 
/*	 // Hibernate template
	 @Bean
	 @DependsOn("sessionFactory")
	 public HibernateTemplate hibernateTemplate() throws SQLException{
		 HibernateTemplate template = new HibernateTemplate(sessionFactory());
		 LOGGER.info("Template detal "+template.getSessionFactory().getStatistics());
		 return template;
	 }*/
	 
	 @Bean
		public HibernateTransactionManager hibTransMan() throws SQLException{
			return new HibernateTransactionManager(sessionFactory());
		}
}
