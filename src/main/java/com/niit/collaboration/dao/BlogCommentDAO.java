package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.BlogComment;

public interface BlogCommentDAO {
	
	
	
	public List<BlogComment> list();
	
	public boolean save(BlogComment blogcomment);
	
	public boolean delete(BlogComment blogcomment);
	
	
	public List<BlogComment> commentlist(String user_id);

}
