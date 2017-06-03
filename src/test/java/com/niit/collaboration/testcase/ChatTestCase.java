package com.niit.collaboration.testcase;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;

import junit.framework.Assert;

public class ChatTestCase {

	@Autowired
	private static Chat chat;

	@Autowired
	private static ChatDAO chatDAO;

	
	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		chat = (Chat) context.getBean("chat");

		chatDAO = (ChatDAO) context.getBean("chatDAO");

	}
	
	
	@Test
	public void createChatTestCase() throws IOException {

		
		
		chat.setUser_id("niit");
		chat.setFriend_id("akshat");
		chat.setCreate_date(new Date());
		chat.setMessage("hi how are you");
		
		

		boolean flag = chatDAO.save(chat);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createChatTestCase", true, flag);

	}

}
