package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ForumDAO;
import com.niit.collaboration.model.Forum;

import junit.framework.Assert;

public class ForumTestCase {


	@Autowired
	private static Forum forum;

	@Autowired
	private static ForumDAO forumDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		forum = (Forum) context.getBean("forum");

		forumDAO = (ForumDAO) context.getBean("forumDAO");

	}
	
	
	@Test
	public void createForumTestCase() throws IOException {

		forum.setId("F01");
		forum.setUser_id("niit");
		forum.setMessage("this is forum");
		forum.setForum_name("My forum name");
		
		
		
		

		boolean flag = forumDAO.save(forum);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createForumTestCase", true, flag);

	}

}
