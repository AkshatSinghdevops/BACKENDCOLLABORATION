package com.niit.collaboration.testcase;

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
	private static BlogCommentDAO  blogcommentDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();

		blogcomment = (BlogComment) context.getBean("blogcomment");

		blogcommentDAO = (BlogCommentDAO) context.getBean("blogcommentDAO");

	}
	
	
	   @Test
       public void createBlogCommentTestCase()  {

		
		blogcomment.setUser_id("niit");
		blogcomment.setBlog_id(2);
		blogcomment.setComment_date(new Date());
		blogcomment.setBlog_comment("this is comment in blog");
		

		boolean flag = blogcommentDAO.save(blogcomment);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createBlogCommentTestCase", true, flag);

	}
}
