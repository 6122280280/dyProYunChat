package com.example.demo.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.bean.Hr;

public class HrUtils {
	public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
