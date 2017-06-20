package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;


@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public User getUser(String id)
	{
		 return  (User)getSession().get(User.class, id);
	}

	@Transactional
	public List<User> list() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public boolean save(User user) {
		try {
			System.out.println("inside save");
			System.out.println("id is "+user.getName());
			
			Query query=sessionFactory.getCurrentSession().createSQLQuery("select c_blog_sequence.nextval from dual ");
       String i=query.list().get(0).toString();
		//System.out.println("i is"+i);
		if(user==null)
		{
			System.out.println("user is null");
		}
		else
		{
			System.out.println(user.getId()+","+user.getName());
			
		}
		user.setId(user.getName());
		user.setRole("Student");
			Session session=sessionFactory.getCurrentSession();
			session.save(user);
			session.flush();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Transactional
	public void setOnline(String userID) {
	
		String hql = "UPDATE User SET isonline='Y' where id='" + userID + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}

	@Transactional
	public void setOffLine(String userID) {
		
		String hql = "UPDATE User SET isonline='N' where id='" + userID + "'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
	
	}
	
	/*@Transactional
	public boolean validate(String id, String password)
	{
		String hql="from User where id='"+ id +"' and password='"+password+"'";
		if(getSession().createQuery(hql).uniqueResult()==null)
		{
			return false;
		}
		return true;
	}*/

	public User get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> list(String string) {
		String hql = "from User where id = '" + string +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	
	@Transactional
	public User validate(String id,String password){
		//String hql="select * from c_user_detail where id='"+id+"' and password='"+password+"'";
		String hql=" from User u " ;
				
		//User user=(User) sessionFactory.getCurrentSession().get(User.class, id);
		            /* sessionFactory.getCurrentSession().create
		List<User> list=query.list();
	if(list.size()==0)
	{
		return null;
	}*/System.out.println("inside validation1");
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<User> users=query.list();
	for(User u : users)
	{
		System.out.println("id is "+u.getId()+"  pass word "+u.getPassword());
		
	}
		for(User u : users)
		{
			System.out.println("id is "+u.getId()+"  pass word "+u.getPassword());
			if(u.getId().equals(id) && u.getPassword().equals(password.trim()))
			{
				return u;
			}
		}
		    /*if(query.list().size()==0)
		    {
		    	System.out.println("inside validation2");
		    	return null;
		    }
		    else
		    {
		    	System.out.println("inside validation3");
		    	return (User)query.list().get(0); }
	}*/
		return null;
	}
}
