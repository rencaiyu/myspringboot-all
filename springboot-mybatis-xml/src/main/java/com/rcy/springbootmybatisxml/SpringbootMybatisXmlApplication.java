package com.rcy.springbootmybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.rcy.springbootmybatisxml.mapper")
public class SpringbootMybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisXmlApplication.class, args);
	}

}
