package com.niit.collaboration.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.BlogCommentDAO;
import com.niit.collaboration.model.BlogComment;


@Transactional
@Repository("blogcommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {

	  @Autowired
	  SessionFactory sessionFactory;
	
	  @Transactional
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	  public BlogCommentDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}
	
	@Transactional
	public List<BlogComment> list() {
		String hql = "from BlogComment";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	@Transactional
	public boolean save(BlogComment blogcomment) {
		try {
			sessionFactory.getCurrentSession().save(blogcomment);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	@Transactional
	public boolean delete(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public List<BlogComment> commentlist(String user_id) {
		String hql="from BlogComment b where b.user_id="+"'"+user_id+"'";
		Query query=sessionFactory.openSession().createQuery(hql);
        return query.list();
	}

}
