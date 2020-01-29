package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class SysRoles {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	public SysRoles() {
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
	public SysRoles(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
