package com.niit.collaboration.daoimpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.ChatDAO;
import com.niit.collaboration.model.Chat;

@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Chat> list() {
            
		String hql="from Chat ";
		
		Query query=sessionFactory.openSession().createQuery(hql);
        
		return query.list();
	}
	@Transactional
	public boolean save(Chat chat) {
		
		
		try{
			chat.setId(getMaxId().intValue());
			sessionFactory.getCurrentSession().save(chat);
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	private BigDecimal getMaxId()
	{
		String hql="select blog_comm_sqe.nextval from dual";
	Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	BigDecimal maxID=null;
     try{
		maxID=(BigDecimal)query.list().get(0);
		System.out.println("maxid is "+maxID);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			
		}return maxID;
	}

}
