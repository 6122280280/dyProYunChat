package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.Menu;
import com.example.demo.mapper.MenuMapper;

@Service
@Transactional
public class MenuService {
	@Autowired
	MenuMapper menuMapper;

	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuMapper.getAllMenu();
	}
}
