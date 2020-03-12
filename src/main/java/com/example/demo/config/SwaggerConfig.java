package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.Data;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //标注一个配置类

@ConfigurationProperties(prefix = "swagger")

@EnableSwagger2 //必须存在
@EnableWebMvc //必须存在
//导入配置文件的data 前缀

@ComponentScan(basePackages = {"com.example.demo.controller"})
public class SwaggerConfig {
	private String title;
    private String description;
    private String version;
    private String name;
    private String url;
    private String email;
    
	   public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public SwaggerConfig(String title, String description, String version, String name, String url, String email) {
		super();
		this.title = title;
		this.description = description;
		this.version = version;
		this.name = name;
		this.url = url;
		this.email = email;
	}

	public SwaggerConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

		@Bean
	    public Docket customDocket() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.useDefaultResponseMessages(false)
	                .apiInfo(apiInfo())
	                .select()
	        		.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
	        		
	                 .paths(PathSelectors.any())
	                 .build();
	        
	    }
	   
	    private ApiInfo apiInfo() {
	        Contact contact = new Contact(name, url, email);
	        return new ApiInfoBuilder()
	                .title(title)
	                .description(description)
	                .contact(contact)
	                .version(version)
	                .build();
	    }
	    
	
}
