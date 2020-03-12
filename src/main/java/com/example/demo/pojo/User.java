package com.example.demo.pojo;

import io.swagger.annotations.ApiModelProperty;

public class User {
	@ApiModelProperty(required = true,notes = "用户名",example = "blues")
	private String username;
	@ApiModelProperty(required = true,notes = "密码",example = "123a")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
