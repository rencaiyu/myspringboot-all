package com.rcy.springbootmybatisannotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rcy.springbootmybatisannotation.mapper")
public class SpringbootMybatisannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisannotationApplication.class, args);
	}

}
