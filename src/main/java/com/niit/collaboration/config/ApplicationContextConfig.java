package com.niit.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.BlogComment;
import com.niit.collaboration.model.Chat;
import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplication;
import com.niit.collaboration.model.User;

@Configuration
@ComponentScan("com.niit.collaboration")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	//private static final Logger logger=LoggerFactory.getLogger(ApplicationContextConfig.class);
	
	
	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
	    DriverManagerDataSource dataSource = new  DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("akshat");
	    dataSource.setPassword("akshat");
	    
	    Properties connectionProperties=new  Properties();
	    connectionProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle11gDialect");
	    dataSource.setConnectionProperties(connectionProperties);
	    return dataSource;
	}	
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(Blog.class);
	    sessionBuilder.addAnnotatedClasses(BlogComment.class);
	    sessionBuilder.addAnnotatedClasses(Forum.class);
	    sessionBuilder.addAnnotatedClasses(Friend.class);
	    sessionBuilder.addAnnotatedClasses(Chat.class);
	    sessionBuilder.addAnnotatedClasses(Job.class);
	    sessionBuilder.addAnnotatedClasses(JobApplication.class);
	    return sessionBuilder.buildSessionFactory();
}
	

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	 
	    return transactionManager;
	}
}
