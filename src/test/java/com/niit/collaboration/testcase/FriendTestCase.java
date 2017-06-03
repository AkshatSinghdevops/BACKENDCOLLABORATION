package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

import junit.framework.Assert;

public class FriendTestCase {

	@Autowired
	private static Friend friend;

	@Autowired
	private static FriendDAO friendDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		friend = (Friend) context.getBean("friend");

		friendDAO = (FriendDAO) context.getBean("friendDAO");

	}
	
	
	@Test
	public void createFriendTestCase() throws IOException {

		friend.setUser_id("niit");
		friend.setFriend_id("akshat");
		friend.setStatus('A');
		friend.setIs_online('Y');
		
		
		
		
		

		boolean flag = friendDAO.save(friend);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createFriendTestCase", true, flag);

	}


}
