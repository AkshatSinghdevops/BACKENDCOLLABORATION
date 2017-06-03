/*package com.niit.collabration.backendcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserController {
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired 
	FriendDAO friendDAO;
	
	@Autowired 
	User user;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/Home")
	public ModelAndView getHomepage()
	{System.out.println("inside home page");
		return new ModelAndView("/Home");
	}
	

	@RequestMapping(value="/singIn")
	public ModelAndView getLoginForm()
	{   
		System.out.println("Now your inter in login page");
		return new ModelAndView("/singIn");
	}
	
	
	
	
	@RequestMapping(value="/user/authenticate/",method=RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User u,HttpSession session){
		System.out.println("inside login");
		//logger.debug("---calling method authenticate");
	User ur=userDAO.validate(u.getId(),u.getPassword());
	System.out.println(ur);
	//ModelAndView mv=new ModelAndView("/homepage");
	  		if(ur==null){
	  			
			ur=new User();//Do we need to create new user?
			ur.setErrorCode("404");
			ur.setErrorMessage("Invalid Credential.Please enter valid credentials");
			//logger.debug("-------invalid credential")
	System.out.println(ur.getErrorMessage());
	System.out.println("1");
	  		}else
		{
			ur.setErrorCode("200");
			ur.setErrorMessage("you have successfully logged in.");
			ur.setIsonline('Y');
			session.setAttribute("loggedInUser",ur);
			session.setAttribute("loggedInUserID",ur.getId());
			System.out.println("userid="+ur.getId());
			session.setAttribute("userID",ur);
		    session.setAttribute("loggedInUserRole",ur.getRole() ); 
		    System.out.println(ur+ur.getRole());
		    		
			friendDAO.setOnline(ur.getId());
			  System.out.println("error code1");
		     userDAO.setOnline(ur.getId());
		     
		     System.out.println("error code");
		     System.out.println(ur.getErrorCode());
		     System.out.println(ur.getErrorMessage());
		     System.out.println("2");
		     
		}
	  		return new ResponseEntity<User>(ur,HttpStatus.OK);//new ResponseEntity<String>(headers,HttpStatus.FOUND);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
*/