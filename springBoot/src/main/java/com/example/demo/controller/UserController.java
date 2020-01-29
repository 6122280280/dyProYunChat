package com.example.demo.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.bean.Hr;
import com.example.demo.bean.Point;
import com.example.demo.bean.SysUser;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.SysUserRepository;

@RequestMapping
@RestController
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private Point point;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	SysUserRepository sysUserRepository;
	@RequestMapping(value="/registers", method=RequestMethod.POST)
	public void saveUser(SysUser user) {
		sysUserRepository.saveAndFlush(new SysUser((long)Math.random()*1000,user.getUsername(),passwordEncoder.encode(user.getPassword())));
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void modifyPassword(String username, String password) {
		point.setX("1");
		System.out.println("point:" + point.getX());
	}
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getUser(SysUser user){
		return userMapper.getUser(user.getUsername());
	}
	
	@RequestMapping(value="/getUserLxrList", method=RequestMethod.POST)
	@ResponseBody
	public List<Hr> getUserLxrList(String username){
		return userMapper.getUserLxrList(username);
	}
	
	@RequestMapping(value="/getSessionList", method=RequestMethod.POST)
	@ResponseBody
	public List<Hr> getSessionList(String username){
		return userMapper.getSessionList(username);
	}
	@RequestMapping(value="/saveNewSession", method=RequestMethod.POST)
	@ResponseBody
	public String saveNewSession(String sendHrId, String acceptHrId, String sessionId){
		Map<String, Object> sessionMap = userMapper.findSessionBySessionId(sendHrId, acceptHrId, sendHrId);
		String msg = "";
		if(sessionMap == null) {
			userMapper.saveNewSession(sendHrId, acceptHrId, sendHrId + acceptHrId, sendHrId);
			msg = "1";
		}else {
			msg = "2";
		}
		return msg;
	}
	@RequestMapping(value="/getSession", method=RequestMethod.GET)
	@ResponseBody
	public String getSession(HttpSession session, HttpServletRequest req){
		
        return session.getAttribute("loginName").toString()+"-----"+req.getServletContext().getRealPath("/"); 
	}
	@RequestMapping(value="/saveMessage", method=RequestMethod.POST)
	@ResponseBody
	public void saveMessage(String sendHrId, String acceptHrId, String message, String sessionId){
		Map<String, Object> sessionMap = userMapper.findSessionBySessionId(sendHrId, acceptHrId, acceptHrId);
		if(sessionMap == null) {
			userMapper.saveNewSession(acceptHrId, sendHrId, sessionId, acceptHrId);
		}
		userMapper.saveMessage(message, sessionId, sendHrId, acceptHrId);
	}
	@RequestMapping(value="/selectMessageList", method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> selectMessageList(String sendHrId, String acceptHrId,String sessionId, int limitNumStart, int limitNumEnd){
		
		return userMapper.selectMessageList(sendHrId, acceptHrId, sessionId, limitNumStart, limitNumEnd);
	}
	@RequestMapping(value="/deleteSession", method=RequestMethod.POST)
	@ResponseBody
	public void deleteSession(String sessionId, String hrUserName){
		
		userMapper.deleteSession(sessionId, hrUserName);
	}
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
	@ResponseBody
	public void uploadFile(MultipartFile  file){
		if (!file.isEmpty()) {
	        try{
	            String name=file.getOriginalFilename();
	            InputStream is = file.getInputStream();
	            File newFile = new File("src/main/resources/static/file");
	            BufferedOutputStream out=new BufferedOutputStream(
	                    new FileOutputStream(newFile));
	            out.write(file.getBytes());
	            out.flush();
	            out.close();
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
		
	}
	
	@RequestMapping("/login_p")
	@ResponseBody
    public void login(HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("{\"status\":\"error\",\"msg\":\"尚未登录，请登录!\"}");
        out.flush();
        out.close();
        //        return new RespBean("error", "尚未登录，请登录!");
    }
}
