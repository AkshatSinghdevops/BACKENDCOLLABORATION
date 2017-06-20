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

		
		blog.setUser_id("akshat");
		blog.setBlog_name("JAVA");
		blog.setCreate_date(new Date());
		blog.setBlog_like(1);
		blog.setStatus("N");
		blog.setDescription("Java is a programming language and a platform Java is a high level, robust, secured and object-oriented programming language.Platform: Any hardware or software environment in which a program runs, is known as a platform. Since Java has its own runtime environment (JRE) and API, it is called platform.USE IN - Web Application An application that runs on the server side and creates dynamic page, is called web application. Currently, servlet, jsp, struts, jsf etc. technologies are used for creating web applications in java.JVM (Java Virtual Machine) is an abstract machine. It is a specification that provides runtime environment in which java bytecode can be executed.JVMs are available for many hardware and software platforms. JVM, JRE and JDK are platform dependent because configuration of each OS differs. But, Java is platform independent.The JVM performs following main tasks:Loads codeVerifies codeExecutes codeProvides runtime environment .JRE is an acronym for Java Runtime Environment.It is used to provide runtime environment.It is the implementation of JVM. It physically exists. It contains set of libraries + other files that JVM uses at runtime.Implementation of JVMs are also actively released by other companies besides Sun Micro Systems.JDK is an acronym for Java Development Kit.It physically exists.It contains JRE + development tools.");
		
		
		

		boolean flag = blogDAO.save(blog);

		// compare what you are excepting VS what you are getting from save
		// method

		Assert.assertEquals("createBlogTestCase", true, flag);

	}
}
