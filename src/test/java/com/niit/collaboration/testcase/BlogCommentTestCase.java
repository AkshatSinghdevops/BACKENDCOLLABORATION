package com.niit.collaboration.testcase;

import java.io.IOException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogCommentDAO;
import com.niit.collaboration.model.BlogComment;

import junit.framework.Assert;

public class BlogCommentTestCase {



	@Autowired
	private static BlogComment blogcomment;

	@Autowired
	private static BlogCommentDAO blogcommentDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		blogcomment = (BlogComment) context.getBean("blogcomment");

		blogcommentDAO = (BlogCommentDAO) context.getBean("blogcommentDAO");

	}
	
	
	@Test
	public void createChatTestCase() throws IOException {

		
		
		blogcomment.setUser_id("niit");
		
		

		boolean flag = blogcommentDAO.save(blogcomment);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createChatTestCase", true, flag);

	}





}