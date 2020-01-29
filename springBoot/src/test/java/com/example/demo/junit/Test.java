package com.example.demo.junit;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.DBUtils;

public class Test {
	
	@org.junit.Test
	public void test1() {
		SqlSession sqlSession = DBUtils.openSqlSession();
//		SqlSession sqlSession2 = DBUtils.openSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		Map<String, Object> user = userMapper.getUser("admin");
//		Map<String, Object> user2 = userMapper2.getUser("admin");
		System.out.println(user.toString() + "<>" );
	}
	@org.junit.Test
	public void test2() {
		
	}
}
