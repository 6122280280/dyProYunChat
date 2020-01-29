package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Hr;
import com.example.demo.bean.Role;
import com.example.demo.mapper.HrMapper;

@Service
@Transactional
public class HrService implements UserDetailsService{
	
	
	@Autowired
	private HrMapper hrMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Hr hr = hrMapper.loadUserByUserName(username);
		if(hr == null) {
			throw new UsernameNotFoundException(username + "用户名错误或不存在！");
		}
		List<Role> roles = hrMapper.getRolesByHrId(hr.getId());
		hr.setRoles(roles);
		
		return hr;
	}

}
