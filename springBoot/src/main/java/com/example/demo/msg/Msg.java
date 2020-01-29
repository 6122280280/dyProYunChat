package com.example.demo.msg;

public class Msg {
	private String content;
	private String title;
	private String extraInfo;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public Msg(String content, String title, String extraInfo) {
		
		this.content = content;
		this.title = title;
		this.extraInfo = extraInfo;
	}
	
}
