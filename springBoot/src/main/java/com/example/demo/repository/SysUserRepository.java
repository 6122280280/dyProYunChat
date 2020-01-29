package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	@Query("select u from SysUser u where u.username =:username")
	SysUser findByUsername(@Param("username") String username);
	
	
}
