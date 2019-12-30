package com.rcy.springbooteasypoi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rcy.springbooteasypoi.mapper")
public class SpringbootEasypoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEasypoiApplication.class, args);
	}

}
