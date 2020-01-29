package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Role;
import com.example.demo.mapper.RoleMapper;

@Component
@Service
public class RoleService implements RoleMapper{
	
	@Autowired
	private RoleMapper roleMapper;
	@Override
	public List<Role> roles() {
		return roleMapper.roles();
	}
	
}
