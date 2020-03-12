package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户模块",tags = "描述用户方法")
public class UserController {
	public static List<User> users =new ArrayList<>();
	
	static {
		users.add(new User("张三","123456"));
		users.add(new User("李四","123456"));

	}
	
	@ApiOperation(value = "获取用户列表",notes = "获取所有用户的列表")
	@GetMapping("/users")
	
	public Object users() {
		
		Map<String,Object> map =new HashMap<>();
		map.put("users", users);
		return map;
		
	}
	@ApiOperation(value = "获取单个用户",notes = "根据Id获取某个用户的信息")
	@ApiImplicitParam(value = "用户Id",paramType = "path")
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return users.get(id);
	}
	@ApiOperation(value = "添加用户",notes = "根据传入信息添加用户")
	@ApiImplicitParam(value = "用户对象",paramType = "query")
	@PostMapping("/user")
	public Object add(User user) {
		return user;
		
	}
	@ApiOperation(value = "删除用户",notes = "根据传入用户Id删除对应的")
	@ApiImplicitParam(value = "用户Id",paramType = "path")
	@DeleteMapping("/user/{id}")
	public Object delete(@PathVariable("id") int id) {
		return users.remove(id);
		
		
	}
}
