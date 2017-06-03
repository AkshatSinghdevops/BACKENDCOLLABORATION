package com.niit.collaboration.dao;

import java.math.BigDecimal;
import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {
	
	public List<Forum> list();
	public Forum get(String userID, Integer forumID);
	public boolean update(Forum forum) ;
	public boolean delete(String userID,BigDecimal commentID);
	public boolean save(Forum chatForum);

}
