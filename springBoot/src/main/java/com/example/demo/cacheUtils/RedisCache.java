package com.example.demo.cacheUtils;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;


public class RedisCache implements Cache{
	private static final Logger logger = Logger.getLogger(RedisCache.class);
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void putObject(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeObject(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
