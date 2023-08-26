package com.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.*;
@Entity
public class Notes {
	@Id
	private int Id;
	private String title;
	private String content;
	private Date addedDate;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public Notes( String title, String content, Date addedDate) {
		super();
		this.Id =new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
	}
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
