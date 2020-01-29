package com.example.demo.mapper;

import java.util.List;

import com.example.demo.bean.Hr;
import com.example.demo.bean.Role;

public interface HrMapper {

	Hr loadUserByUserName(String username);
	List<Role> getRolesByHrId(Long id);
}	
