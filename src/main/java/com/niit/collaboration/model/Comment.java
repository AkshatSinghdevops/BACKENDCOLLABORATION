package com.niit.collaboration.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="C_COMMENT")
@Component
public class Comment {
	
	@Id
	private BigDecimal id;
	
	private String user_id;
	
	private String forum_id;
	
	private String forum_comment;
	
	private Date comment_date;
	
	private int rating;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getForum_id() {
		return forum_id;
	}

	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_comment() {
		return forum_comment;
	}

	public void setForum_comment(String forum_comment) {
		this.forum_comment = forum_comment;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
