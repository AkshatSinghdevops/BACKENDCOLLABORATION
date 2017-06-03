package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

import junit.framework.Assert;

public class BlogTestCase {

	@Autowired
	private static Blog blog;

	@Autowired
	private static BlogDAO blogDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		blog = (Blog) context.getBean("blog");

		blogDAO = (BlogDAO) context.getBean("blogDAO");

	}
	
	
	@Test
       public void createBlogTestCase()  {

		
		blog.setUser_id("niit");
		blog.setBlog_name("New blog name");
		blog.setCreate_date(new Date());
		blog.setBlog_like(0);
		blog.setStatus("N");
		
		
		

		boolean flag = blogDAO.save(blog);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createBlogTestCase", true, flag);

	}
}
