package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="C_BLOG_COMMENT")
@Component
public class BlogComment extends BaseDomain {
	
	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blog_comm_sqe")
	@SequenceGenerator(name="blog_comm_sqe", sequenceName="blog_comm_sqe", allocationSize=1)
	@Column(name="ID")
	private int id;
	
	@Column(name="BLOG_ID")
	private int blog_id;
	
	
	private String user_id;
	
	private String blog_comment;
	
	private Date comment_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBlog_comment() {
		return blog_comment;
	}

	public void setBlog_comment(String blog_comment) {
		this.blog_comment = blog_comment;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	
	

}
