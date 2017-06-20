package com.niit.collaboration.testcase;


import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

import junit.framework.Assert;



public class UserTestCase {

	@Autowired
	private static User user;

	@Autowired
	private static UserDAO userDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		user = (User) context.getBean("user");

		userDAO = (UserDAO) context.getBean("userDAO");

	}
	
	/*@Test
	public void validateTestCase()
	{
		boolean flag=userDAO.validate("niit", "niit");
		Assert.assertEquals("validateTestCase", true, flag);
	}
*/
	//@Test
	//public void getuserdetails(){
		//boolean flag = userDAO.getUser("niit") != null;
	   //Assert.assertEquals("getuserdetails", true, flag);		
	//}
	
	@Test
	public void createUserTestCase()  {

		
	    user.setId("akshat");
		user.setName("akshat");
		user.setPassword("akshat");
		user.setAddress("Arera Bhopal");
		user.setEmail("akshat@gmail.com");
		user.setMobile("1234567895");
		user.setRole("Admin");
		user.setDob("12/12/1999");
		user.setIsonline('Y');
		user.setGender("male");
		user.setStatus('A');
		
		

		boolean flag = userDAO.save(user);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createUserTestCase", true, flag);
        // assertEquals("createUserTestCase", true, flag);
	}
}
	
	