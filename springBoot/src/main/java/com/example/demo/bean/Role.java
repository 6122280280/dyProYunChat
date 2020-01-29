package com.example.demo.bean;

import java.io.Serializable;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String name;
    private String nameZh;
    public Role() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
    
}
