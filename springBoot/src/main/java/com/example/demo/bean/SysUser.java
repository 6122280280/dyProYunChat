package com.example.demo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Entity
public class SysUser implements UserDetails,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List<SysRoles> roles;
	public SysUser(Long id, String username2, String encode) {
		this.id = id;
		this.username = username2;
		this.password = encode;
	}
	public SysUser() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		List<SysRoles> roles = this.getRoles();
		for(SysRoles role: roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		return auths;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<SysRoles> getRoles() {
		return roles;
	}
	public void setRoles(List<SysRoles> roles) {
		this.roles = roles;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
