package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
	@Api(value = "用户模块")
	public class HelloController {
	    @GetMapping("/hello")
	    @ApiOperation(value = "测试Swagger")
	    public String hello(){
	        return "hello SpringBoot-swagger";
	    }
	}
