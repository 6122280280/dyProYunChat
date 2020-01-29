package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.demo.bean.Hr;

//@CacheConfig(cacheNames="user")
public interface UserMapper {
	
	Map<String, Object> getUser(String username);

	List<Hr> getUserLxrList(String username);


	void modifyPassword(@Param("username") String username, @Param("password") String password);

	void saveMessage(@Param("message") String message, @Param("sessionId") String sessionId, @Param("sendHrId") String sendHrId, @Param("acceptHrId") String acceptHrId);

	void saveMessageUnionHr(@Param("sendHrId") String sendHrId, @Param("acceptHrId") String acceptHrId, @Param("sessionId") String sessionId, @Param("hrUserName") String hrUserName);

	List<Map<String,Object>> selectMessageList(@Param("sendHrId") String sendHrId, @Param("acceptHrId") String acceptHrId, @Param("sessionId") String sessionId, @Param("limitNumStart") int limitNumStart, @Param("limitNumEnd") int limitNumEnd);

	void saveNewSession(@Param("sendHrId")String sendHrId, @Param("acceptHrId")String acceptHrId, @Param("sessionId") String sessionId, @Param("hrUserName") String hrUserName);

	Map<String, Object> findSessionBySessionId(@Param("sendHrId") String sendHrId, @Param("acceptHrId") String acceptHrId, @Param("hrUserName") String hrUserName);

	List<Hr> getSessionList(@Param("hrUserName") String hrUserName);

	void deleteSession(@Param("sessionId") String sessionId, @Param("hrUserName") String hrUserName);
}
