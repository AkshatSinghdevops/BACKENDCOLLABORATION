package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Chat;

public interface ChatDAO {
	
	public List<Chat> list();
	
	public boolean save(Chat chat);

}
